package com.erecrutement.Controllers;


import com.erecrutement.Entities.Candidat;
import com.erecrutement.Entities.Entreprise;
import com.erecrutement.Entities.Role;
import com.erecrutement.Entities.User;
import com.erecrutement.Repositories.CandidatRepository;
import com.erecrutement.Repositories.UserRepository;
import com.erecrutement.Validators.UserValidator;
import com.erecrutement.ViewModels.CandidatSignupForm;
import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    @GetMapping({"/", "/candidat"})
    public String signupForm (Candidat candidat) {
        return "signup/candidat";
    }

    @PostMapping("/candidat")
    public String register(@Valid Candidat candidat,
//                           @RequestParam("radioType") String type,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        userValidator.validate(candidat,bindingResult);

        if(bindingResult.hasErrors()) {
            return "signup/candidat";
        }

        userRepository.save(candidat);

        redirectAttributes.addFlashAttribute("signupSuccess", "Inscription réussite ! Vous pouvez maintenant accéder à la plateforme.");

        return "redirect:/";
    }
}
