package com.erecrutement.Controllers;

import com.erecrutement.Entities.Cv;
import com.erecrutement.Entities.Image;
import com.erecrutement.Repositories.CompetencesRepository;
import com.erecrutement.Repositories.CvRepository;
import com.erecrutement.Repositories.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;

/**
 * Created by saba on 04/12/16.
 */
@Controller
public class HomeController {


    @RequestMapping({"/", "/index"})
    public String index(Principal principal) {
        return "index";
    }

    @RequestMapping("/template")
    public String template(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "mon petit monsieur ! ! ");
        return "redirect:/";
    }

    @RequestMapping("/403")
    public String permissionDenied() {
        return "403";
    }


}

