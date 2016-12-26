package com.erecrutement.Controllers;

import com.erecrutement.Entities.Entreprise;
import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Entities.Offres.OffreCDD;
import com.erecrutement.Entities.Offres.OffreCDI;
import com.erecrutement.Entities.Offres.OffrePFE;
import com.erecrutement.Services.OffreService;
import com.erecrutement.Services.UserService;
import com.erecrutement.ViewModels.OffreForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by saba on 07/12/16.
 */
@Controller
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired
    private UserService userService;

    @Autowired
    private OffreService offreService;

    @RequestMapping("/")
    public String index() {
        System.out.println("bonjour");
        return "entreprise/index";
    }

    @RequestMapping("/offres")
    public String offres(Principal principal, Model model) {
        Entreprise entreprise = (Entreprise) userService.findByUsername(principal.getName());
        List<Offre> offres = (List<Offre>) entreprise.getOffres();
        System.out.println(offres.size());
        model.addAttribute("offres", offres);
        return "entreprise/offres";
    }

    @GetMapping("/offre/add")
    public String getAddOffre() {
        return "entreprise/offre/add";
    }

    @PostMapping("/offre/add")
    public String postAddOffre(@ModelAttribute OffreForm form, Principal principal) {

        Entreprise entreprise = (Entreprise)userService.findByUsername(principal.getName());

        String type = form.getType();
        String description = form.getDescription().replaceAll("\\r?\\n", "<br />");
        String missions = form.getMissions().replaceAll("\\r?\\n", "<br />");
        String requis = form.getRequis().replaceAll("\\r?\\n", "<br />");

        switch (type) {
            case "pfe":
                OffrePFE offrePFE = new OffrePFE();

                offrePFE.setDatePublished(new Date());
                offrePFE.setTitle(form.getTitle());
                offrePFE.setPlace(form.getPlace());
                offrePFE.setDescription(description);
                offrePFE.setMissions(missions);
                offrePFE.setRequis(requis);
                offrePFE.setPreembauche(form.isPreembauche());
                offrePFE.setDuration(Integer.parseInt(form.getDuration()));

                offrePFE.setEntreprise(entreprise);

                offreService.save(offrePFE);
                break;
            case "cdd":
                OffreCDD offreCDD = new OffreCDD();

                offreCDD.setDatePublished(new Date());
                offreCDD.setTitle(form.getTitle());
                offreCDD.setPlace(form.getPlace());
                offreCDD.setDescription(description);
                offreCDD.setMissions(missions);
                offreCDD.setRequis(requis);
                offreCDD.setDuration(Integer.parseInt(form.getDuration()));
                offreCDD.setPoste(form.getPoste());

                offreCDD.setEntreprise(entreprise);

                offreService.save(offreCDD);
                break;
            case "cdi":
                OffreCDI offreCDI = new OffreCDI();

                offreCDI.setDatePublished(new Date());
                offreCDI.setTitle(form.getTitle());
                offreCDI.setPlace(form.getPlace());
                offreCDI.setDescription(description);
                offreCDI.setMissions(missions);
                offreCDI.setRequis(requis);
                offreCDI.setPoste(form.getPoste());

                offreCDI.setEntreprise(entreprise);

                offreService.save(offreCDI);
                break;
        }
        userService.update(entreprise);
        return "redirect:/entreprise/offres";
    }

}
