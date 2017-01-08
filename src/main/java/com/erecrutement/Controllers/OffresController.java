package com.erecrutement.Controllers;

import com.erecrutement.Entities.Candidat;
import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Entities.Offres.OffreCandidat;
import com.erecrutement.Helpers.OffreHelper;
import com.erecrutement.Services.CandidatService;
import com.erecrutement.Services.OffreService;
import com.erecrutement.ViewModels.OffreViewModel;
import com.erecrutement.ViewModels.OffresViewModel;
import com.erecrutement.ViewModels.RechercheViewModel;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.*;

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

        if (principal != null) {
            Candidat candidat = candidatService.findByUsername(principal.getName());
            boolean hasApplied = OffreHelper.hasApplied(offre, candidat);
            model.addAttribute("hasApplied", hasApplied);
        }

        model.addAttribute("offre", offre);
        model.addAttribute("type", OffreHelper.offreType(offre));

        return "offres/offre-details";
    }

    @Secured("ROLE_CANDIDAT")
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

    @PostMapping("/recherche")
    public String rechercher(@ModelAttribute RechercheViewModel filters, Model model) {
        List<Offre> offres = offreService.findAll();
        List<Offre> filteredOffres = filter(offres, filters);
        model.addAttribute("offres", filteredOffres);

        System.out.println(filteredOffres.size());
        return "offres/index";
    }

    private List<Offre> filter(List<Offre> offres, RechercheViewModel filters) {
        List<Offre> filtredOffres;
        filtredOffres = filterMotsCles(offres, filters.getMotcle());
        filtredOffres = filterSecteur(filtredOffres, filters.getSecteur());
        filtredOffres = filterLieu(filtredOffres, filters.getLieu());
        return filtredOffres;
    }

    private List<Offre> filterMotsCles(List<Offre> offres, String motsCles) {
        List<Offre> filteredOffres = new ArrayList<>();

        if(!motsCles.isEmpty()) {
            List<String> keyWordsArray = Arrays.asList(motsCles.split("\\s*,\\s*"));

            for(Offre offre: offres) {
                for(String keyWord: keyWordsArray) {
                    if(containsKeyWord(offre.getTitle(), keyWord)) {
                        filteredOffres.add(offre);
                    }
                }
            }
            return filteredOffres;
        }
        return offres;
    }

    private List<Offre> filterSecteur(List<Offre> offres, String secteur) {
        List<Offre> filtredOffres = new ArrayList<>();
        if (!secteur.isEmpty()) {
            for (Offre offre : offres) {
                if (offre.getDomain().equals(secteur))
                    filtredOffres.add(offre);
            }
            return filtredOffres;
        }
        return offres;
    }

    private List<Offre> filterType(List<Offre> offres, String type) {
        List<Offre> filtredOffres = new ArrayList<>();
        if (!type.isEmpty()) {
            for (Offre offre : offres) {
                if (OffreHelper.offreType(offre).equals(type)) {
                    filtredOffres.add(offre);
                }
            }
            return filtredOffres;
        }
        return offres;
    }

    private List<Offre> filterMetier(List<Offre> offres, String metier) {
        List<Offre> filtredOffres = new ArrayList<>();
        if (!metier.isEmpty()) {

            return filtredOffres;
        }
        return offres;
    }

    private List<Offre> filterLieu(List<Offre> offres, String lieu) {
        List<Offre> filtredOffres = new ArrayList<>();
        if (!lieu.isEmpty()) {
            for (Offre offre : offres) {
                if (offre.getPlace().equals(lieu)) {
                    filtredOffres.add(offre);
                }
            }
            return filtredOffres;
        }
        return offres;
    }

    public boolean containsKeyWord(String str, String keyWord) {
        return str.matches(".*" + keyWord + ".*");
    }
}
