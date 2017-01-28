package com.erecrutement.Controllers;

import com.erecrutement.Entities.User.Candidat;
import com.erecrutement.Entities.User.Entreprise;
import com.erecrutement.Entities.Role;
import com.erecrutement.Repositories.UserRepository;
import com.erecrutement.Validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

        candidat.getRoles().add(new Role("CANDIDAT",""));

        userRepository.save(candidat);

        redirectAttributes.addFlashAttribute("signupSuccess", "Inscription réussite ! Vous pouvez maintenant accéder à la plateforme.");

        return "redirect:/";
    }

    @GetMapping("/entreprise")
    public String signupFormEntreprise(Entreprise entreprise) {
        return "signup/entreprise";
    }
    @PostMapping("/entreprise")
    public String registerEntreprise(Entreprise entreprise,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {

        userValidator.validate(entreprise,bindingResult);
        if(bindingResult.hasErrors()) {
            return "signup/entreprise";
        }
        entreprise.getRoles().add(new Role("ENTREPRISE",""));
        userRepository.save(entreprise);

        redirectAttributes.addFlashAttribute("signupSuccess", "Inscription réussite ! Vous pouvez maintenant accéder à la plateforme.");

        return "redirect:/";
    }
}
