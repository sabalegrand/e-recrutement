package com.erecrutement.Controllers;

import com.erecrutement.Entities.User.Candidat;
import com.erecrutement.Entities.Cv;
import com.erecrutement.Entities.LocalCv;
import com.erecrutement.Services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private CandidatService candidatService;

    @RequestMapping("/candidat/{id}")
    public String profileCandidat(@PathVariable("id") int id,
                                  Model model) {

        Candidat candidat = candidatService.find(id);
        Collection<Cv> cvs = candidat.getCvs();
        LocalCv localCv = new LocalCv();

        for(Cv cv: cvs) {
            if(cv instanceof LocalCv) {
                localCv = (LocalCv)cv;
            }
        }

        model.addAttribute("candidat", candidat);
        model.addAttribute("localCv", localCv);

        return "/profile/candidat";
    }
}
