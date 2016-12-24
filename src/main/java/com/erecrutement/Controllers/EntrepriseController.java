package com.erecrutement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saba on 07/12/16.
 */
@Controller
public class EntrepriseController {

    @RequestMapping("/entreprise")
    String index() {
        System.out.println("bonjour");
        return "entreprise/index";
    }

}
