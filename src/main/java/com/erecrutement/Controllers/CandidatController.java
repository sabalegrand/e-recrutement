package com.erecrutement.Controllers;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.erecrutement.Entities.*;
import com.erecrutement.Repositories.CvRepository;
import com.erecrutement.Services.CandidatService;
import com.erecrutement.Services.ExperienceService;
import com.erecrutement.Services.FormationService;
import com.erecrutement.Services.UserService;
import com.erecrutement.ViewModels.ExperienceForm;
import com.erecrutement.ViewModels.XeditableForm;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/candidat")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private FormationService formationService;

    @Autowired
    private CvRepository cvRepository;

    @RequestMapping("/")
    public String index() {
        return "candidat/index";
    }

    @RequestMapping("/truc")
    public String truc() {
        return "candidat/truc";
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount (RedirectAttributes redirectAttributes, Principal principal) {

        candidatService.delete(principal.getName());

        redirectAttributes.addFlashAttribute("accountDeleted", "Votre compte a bien été supprimer.");

        return "redirect:/";
    }

    @RequestMapping("/profile")
    public String profile(Principal principal, Model model) {

        Candidat candidat = candidatService.findByUsername(principal.getName());
        Collection<Cv> cvs = candidat.getCvs();
        LocalCv localCv = null;

        for(Cv cv: cvs) {
            if(cv instanceof LocalCv) {
                localCv = (LocalCv)cv;
            }
        }


        model.addAttribute("candidat", candidat);
        model.addAttribute("localCv", localCv);
//        model.addAttribute("experiences", experiences);
//        model.addAttribute("formations", formations);

        return "candidat/profile";
    }

    @PostMapping("/experience/add")
    public String addExperience(@ModelAttribute ExperienceForm experienceForm, Principal principal) throws ParseException {

        Candidat candidat = candidatService.findByUsername(principal.getName());
        Collection<Cv> cvs = candidat.getCvs();
        LocalCv localCv = null;

            // on récup cv local parmis la liste des cvs
        for(Cv cv: cvs) {
            if(cv instanceof LocalCv) {
                localCv = (LocalCv)cv;
            }
        }
            // si pas de cv local dans la liste de cvs
        if(localCv == null) {
            localCv = new LocalCv();
            candidat.getCvs().add(localCv);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date debut = formatter.parse(experienceForm.getDebut()),
             fin  = formatter.parse(experienceForm.getFin());

        Experience experience = new Experience();
        experience.setTitre(experienceForm.getTitre());
        experience.setLieu(experienceForm.getLieu());
        experience.setDebut(debut);
        experience.setFin(fin);
        experience.setDescription(experienceForm.getDescription().replaceAll("\\r?\\n", "<br />"));

        localCv.getExperiences().add(experience);

        candidatService.update(candidat);

        return "redirect:/candidat/profile";
    }

    @PostMapping("/formation/add")
    public String addFormation(@ModelAttribute ExperienceForm formationForm, Principal principal) throws ParseException {

        Candidat candidat = candidatService.findByUsername(principal.getName());
        Collection<Cv> cvs = candidat.getCvs();
        LocalCv localCv = null;

        // on récup cv local parmis la liste des cvs
        for(Cv cv: cvs) {
            if(cv instanceof LocalCv) {
                localCv = (LocalCv)cv;
            }
        }
        // si pas de cv local dans la liste de cvs
        if(localCv == null) {
            localCv = new LocalCv();
            candidat.getCvs().add(localCv);
        }
            // creation + remplissage objet formation
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date debut = formatter.parse(formationForm.getDebut()),
                fin  = formatter.parse(formationForm.getFin());

        Formation formation = new Formation();
        formation.setFormation(formationForm.getTitre());
        formation.setLieu(formationForm.getLieu());
        formation.setDebut(debut);
        formation.setFin(fin);
        formation.setDescription(formationForm.getDescription().replaceAll("\\r?\\n", "<br />"));

        localCv.getFormations().add(formation);

        candidatService.update(candidat);

        return "redirect:/candidat/profile";
    }

        // X-EDITABLE MODIFICATIONS
    @PostMapping("/profile/edit/username")
    public ResponseEntity<String> editUsername(@ModelAttribute XeditableForm form) {


        Candidat candidat = candidatService.findByUsername(form.getPk());

        System.out.println(form.getPk());
        if(candidatService.findByUsername(form.getValue()) != null) {
            return ResponseEntity.badRequest().body("Cette adresse email est déjà utilisée");
        }
        candidat.setUsername(form.getValue());
        candidatService.save(candidat);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/profile/edit/personalPhoneNumber")
    public ResponseEntity<String> editPersonalPhoneNumber(@ModelAttribute XeditableForm form) {

        Candidat candidat = candidatService.findByUsername(form.getPk());
        candidat.setPersonalPhoneNumber(form.getValue());
        candidatService.save(candidat);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/profile/edit/firstName")
    public ResponseEntity<String> editFirstName(@ModelAttribute XeditableForm form) {

        Candidat candidat = candidatService.findByUsername(form.getPk());
        candidat.setFirstName(form.getValue());
        candidatService.save(candidat);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/profile/edit/lastName")
    public ResponseEntity<String> editLastNAme(@ModelAttribute XeditableForm form) {

        Candidat candidat = candidatService.findByUsername(form.getPk());
        candidat.setLastName(form.getValue());
        candidatService.save(candidat);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/profile/edit/country")
    public ResponseEntity<String> editCountry(@ModelAttribute XeditableForm form) {
        Candidat candidat = candidatService.findByUsername(form.getPk());
        candidat.setCountry(form.getValue());
        candidatService.save(candidat);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/profile/edit/avatar")
    public String editAvatar(@RequestParam("images") MultipartFile avatar, Principal principal) throws IOException {
        String filename = avatar.getOriginalFilename();
        System.out.println("avatar modifié");
//        if (avatar.getSize() != 0) {
//            Candidat candidat = candidatService.findByUsername(principal.getName());
//            byte[] bytes = avatar.getBytes();
//            Image image = new Image();
//            image.setData(bytes);
//            candidatService.save(candidat);
//        }
        return "redirect:/candidat/profile";
    }



//    @GetMapping("/uploadCv")
//    String uploadCv() {
//        return
//    }
}
