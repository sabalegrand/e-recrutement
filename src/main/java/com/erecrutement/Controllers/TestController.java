package com.erecrutement.Controllers;

import com.erecrutement.Entities.*;
import com.erecrutement.Repositories.CvRepository;
import com.erecrutement.Repositories.ExperienceRepository;
import com.erecrutement.Repositories.ImageRepository;
import com.erecrutement.Services.CandidatService;
import com.erecrutement.ViewModels.ExperienceForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by saba on 13/12/16.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private CandidatService candidatService;

    @RequestMapping("/")
    @ResponseBody
    public Object index() {

        Candidat candidat = candidatService.findByUsername("tsertsvadzesaba@gmail.com");
        Collection<Cv> cvs = candidat.getCvs();

        for(Cv cv: cvs) {
            if(cv instanceof CvPortfolio) {
                return cv;
            }
        }

        return "ok";
    }
    @RequestMapping("/add-cv")
    @ResponseBody
    public String addCv() {

        Candidat candidat = candidatService.findByUsername("tsertsvadzesaba@gmail.com");
        CvPortfolio cvPortfolio = new CvPortfolio();
        cvPortfolio.setUrl("saba");
        candidat.getCvs().add(cvPortfolio);
        candidatService.save(candidat);
        return "ok";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException {

//        String filename = file.getOriginalFilename();
//        System.out.println();
//        if (file.getSize() != 0) {
//            byte[] bytes = file.getBytes();
//
//            Cv cv = new Cv();
//            cv.setData(bytes);
//            cv.setName(file.getOriginalFilename());
//            cvRepository.save(cv);
//        }
        return "redirect:/";
    }

    @GetMapping("/image")
    public String image(Model model) {

        List<Image> images = imageRepository.findAll();

        model.addAttribute("images", images);


        return "test/image";
    }

    @PostMapping("/image")
    public String imageUpload(@RequestParam("file") MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();
        System.out.println();
        if (file.getSize() != 0) {
            byte[] bytes = file.getBytes();
            Image image = new Image();
            image.setData(bytes);
            imageRepository.save(image);
        }
        return "redirect:/test/image";
    }

    @GetMapping("/image/{id}")
    public void display(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        Image image = imageRepository.findOne(id);
        response.setContentType("image/jpeg, image/jpg, image/png");
        response.getOutputStream().write(image.getData());
    }

    @GetMapping("/download/image/{id}")
    public void download(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        Image file = imageRepository.findOne(id);

        if (file != null) {
            ByteArrayInputStream bis = new ByteArrayInputStream(file.getData());

            String contentType = URLConnection.guessContentTypeFromStream(bis);
            response.setContentType(contentType);

            response.addHeader("Content-Disposition", "attachment; filename=" + "bonjour");
            response.getOutputStream().write(file.getData());
        }
    }

    @GetMapping("/xeditable")
    public String xeditable() {
        return "test/xeditable";
    }

    @PostMapping("/xeditable")
    public void xeditablePost(HttpServletRequest request) {

        System.out.println("xeditable post");
    }

    @GetMapping("/ajax-post")
    public String ajaxPost(Model model) {

        List<Experience> experiences = experienceRepository.findAll();
        model.addAttribute("experiences", experiences);

        return "test/ajax-post";
    }

    @PostMapping("/ajax-post")
    public String ajaxPostResponse(@ModelAttribute ExperienceForm experienceForm) {
        Experience experience = new Experience();
        experience.setTitre(experienceForm.getTitre());
        experience.setLieu(experienceForm.getLieu());
        experience.setDebut(new Date());
        experience.setFin(new Date());
        experience.setDescription(experienceForm.getDescription().replaceAll("\\r?\\n", "<br />"));
//        experienceRepository.save(experience);
//        ObjectMapper mapper = new ObjectMapper();
//
//        String res = mapper.writeValueAsString(experienceForm);
//        return ResponseEntity.badRequest();
        return "redirect:/test/ajax-post";
    }

    @PostMapping("/multiple-values")
    public void multipleValues(@RequestParam("values") String[] values) {
        for (String value :
                values) {
            System.out.println(value);
        }
    }

}
