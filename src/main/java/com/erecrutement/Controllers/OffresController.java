package com.erecrutement.Controllers;

import com.erecrutement.Entities.Candidat;
import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Entities.Offres.OffreCandidat;
import com.erecrutement.Helpers.OffreHelper;
import com.erecrutement.Services.CandidatService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by saba on 28/12/16.
 */
@Controller
@RequestMapping("/offres")
public class OffresController {

    @Autowired
    private OffreService offreService;

    @Autowired
    private CandidatService candidatService;

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
            offreViewModel.setId(offre.getId());
            offreViewModel.setTitle(offre.getTitle());
            offreViewModel.setDatePublished(offre.getDatePublished());
            offreViewModel.setEntreprise(offre.getEntreprise().getCompanyName());

            offres.getOffres().add(offreViewModel);
        });

        return offres;
    }


    @RequestMapping("/details/{id}")
    public String offreDetails(@PathVariable("id") int id,
                               Model model, Principal principal) {

        Offre offre = offreService.find(id);

//        if(principal != null) {
//            Candidat candidat = candidatService.findByUsername(principal.getName());
//            model.addAttribute("candidatOffres", candidat.getOffreCandidats());
//        }

        model.addAttribute("offre", offre);
        model.addAttribute("type", OffreHelper.offreType(offre));

        return "offres/offre-details";
    }

    @RequestMapping("/postuler/{id}")
    public String postuler(@PathVariable("id") int id, Principal principal) {
        System.out.println("postuler");

        Candidat candidat = candidatService.findByUsername(principal.getName());
        Offre offre = offreService.find(id);
        OffreCandidat offreCandidat = new OffreCandidat();
        offreCandidat.setCandidat(candidat);
        offreCandidat.setOffre(offre);
        offreCandidat.setDatePostul(new Date());
        offreCandidat.setState(OffreHelper.ENATTENTE);

        candidat.getOffreCandidats().add(offreCandidat);

        candidatService.update(candidat);

        return "redirect:/offres/";
    }
}
