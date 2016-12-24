package com.erecrutement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saba on 04/12/16.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    String login(Model model, String error, String logout) {
        return "login";
    }

    @RequestMapping("/logout")
    String logout() {
        return "logout";
    }

}
