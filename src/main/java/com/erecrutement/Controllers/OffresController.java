package com.erecrutement.Controllers;

import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Services.OffreService;
import com.erecrutement.ViewModels.OffreViewModel;
import com.erecrutement.ViewModels.OffresViewModel;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/load")
    @ResponseBody
    public OffresViewModel offres(Pageable pageable) {


        OffresViewModel offres = new OffresViewModel();
        Page<Offre> res = offreService.findAll(pageable);

        res.forEach(offre -> {
            OffreViewModel offreViewModel = new OffreViewModel();
            offreViewModel.setTitle(offre.getTitle());
            offreViewModel.setDatePublished(offre.getDatePublished());
            offreViewModel.setEntreprise(offre.getEntreprise().getCompanyName());

            offres.getOffres().add(offreViewModel);
        });

        return offres;
    }

}
