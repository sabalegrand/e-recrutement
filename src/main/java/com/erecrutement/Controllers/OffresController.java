package com.erecrutement.Controllers;

import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Services.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

/**
 * Created by saba on 28/12/16.
 */
@Controller
@RequestMapping("/offres")
public class OffresController {

    @Autowired
    private OffreService offreService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Offre> offres = offreService.findAll();

        model.addAttribute("offres", offres);

        return "offres/index";
    }

}
