package com.erecrutement.Controllers;

import com.erecrutement.Entities.Entreprise;
import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Entities.Offres.OffreCDD;
import com.erecrutement.Entities.Offres.OffreCDI;
import com.erecrutement.Entities.Offres.OffrePFE;
import com.erecrutement.Services.OffreService;
import com.erecrutement.Services.UserService;
import com.erecrutement.ViewModels.OffreForm;
import com.erecrutement.ViewModels.XeditableForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Float remuneration = Float.parseFloat(form.getRemuneration());
        String description = form.getDescription().replaceAll("\\r?\\n", "<br />");
        String missions = form.getMissions().replaceAll("\\r?\\n", "<br />");
        String requis = form.getRequis().replaceAll("\\r?\\n", "<br />");

        switch (type) {
            case "pfe":
                OffrePFE offrePFE = new OffrePFE();

                offrePFE.setDatePublished(new Date());
                offrePFE.setTitle(form.getTitle());
                offrePFE.setPlace(form.getPlace());
                offrePFE.setRemuneration(remuneration);
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
                offreCDD.setRemuneration(remuneration);
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
                offreCDI.setRemuneration(remuneration);
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

    @RequestMapping("/offre/{id}")
    public String offreDetails(@PathVariable("id") int idOffre, Model model) {

        Offre offre = offreService.find(idOffre);

        model.addAttribute("offre", offre);

        return "/entreprise/offre/index";
    }

    // X-EDITABLE MODIFICATIONS
    @PostMapping("/offre/edit/duration")
    public ResponseEntity<String> editDuration(@ModelAttribute XeditableForm form) {
        Offre o = offreService.find(Integer.parseInt(form.getPk()));
        int duration = Integer.parseInt(form.getValue());

        if(o instanceof OffreCDD) {
            OffreCDD offre = (OffreCDD)o;
            offre.setDuration(duration);
        } else if (o instanceof OffrePFE) {
            OffrePFE offre = (OffrePFE)o;
            offre.setDuration(duration);
        } else {
            return ResponseEntity.badRequest().body("Une erreur s'est produite.");
        }
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/offre/edit/place")
    public ResponseEntity<String> editPlace(@ModelAttribute XeditableForm form) {
        Offre o = offreService.find(Integer.parseInt(form.getPk()));
        String place  = form.getValue();

        o.setPlace(place);
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/offre/edit/remuneration")
    public ResponseEntity<String> editRemuneration(@ModelAttribute XeditableForm form) {
        Offre o = offreService.find(Integer.parseInt(form.getPk()));
        float remuneration  =Float.parseFloat(form.getValue());

        o.setRemuneration(remuneration);
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/offre/edit/description")
    public ResponseEntity<String> editDescription(@RequestParam("id") String id, @RequestParam("data") String data) {
        Offre o = offreService.find(Integer.parseInt(id));

        o.setDescription(data);
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/offre/edit/missions")
    public ResponseEntity<String> editMissions(@ModelAttribute XeditableForm form) {
        Offre o = offreService.find(Integer.parseInt(form.getPk()));
        String missions  = form.getValue().replaceAll("\\r?\\n", "<br />");

        o.setMissions(missions);
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/offre/edit/requis")
    public ResponseEntity<String> editRequis(@ModelAttribute XeditableForm form) {
        Offre o = offreService.find(Integer.parseInt(form.getPk()));
        String requis  = form.getValue().replaceAll("\\r?\\n", "<br />");

        o.setRequis(requis);
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }
    @PostMapping("/offre/edit/post")
    public ResponseEntity<String> editPost(@ModelAttribute XeditableForm form) {
        Offre o = offreService.find(Integer.parseInt(form.getPk()));
        String post = form.getValue();

        if(o instanceof OffreCDD) {
            OffreCDD offre = (OffreCDD)o;
            offre.setPoste(post);
        } else if (o instanceof OffreCDI) {
            OffreCDI offre = (OffreCDI)o;
            offre.setPoste(post);
        }
        offreService.update(o);

        return ResponseEntity.ok("ok");
    }

}
