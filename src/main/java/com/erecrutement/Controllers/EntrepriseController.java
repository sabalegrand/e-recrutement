package com.erecrutement.Controllers;

import com.erecrutement.Entities.Entreprise;
import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * Created by saba on 07/12/16.
 */
@Controller
public class EntrepriseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/entreprise")
    String index() {
        System.out.println("bonjour");
        return "entreprise/index";
    }

    @RequestMapping("/offres")
    String offres(Principal principal, Model model) {
        Entreprise entreprise =(Entreprise)userService.findByUsername(principal.getName()) ;
        List<Offre> offres =(List<Offre>) entreprise.getOffres();
        model.addAttribute("offres",offres);
        return "entreprise/offres";
    }

}
