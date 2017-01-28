package com.erecrutement.Controllers;

import com.erecrutement.Entities.User.Notification;
import com.erecrutement.Entities.User.User;
import com.erecrutement.Repositories.NotificationRepository;
import com.erecrutement.Services.NotificationService;
import com.erecrutement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

/**
 * Created by saba on 28/01/17.
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

    @GetMapping("/notifications")
    @ResponseBody
    public List<Notification> getNotifications(Principal principal) {

        if(principal != null) {
            User user = userService.findByUsername(principal.getName());
            List<Notification> notifications = (List<Notification>) user.getNotifications();
            return notifications;
        }
        return null;
    }
}
