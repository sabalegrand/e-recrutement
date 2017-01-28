package com.erecrutement;

import com.erecrutement.Entities.Role;
import com.erecrutement.Entities.User.Candidat;
import com.erecrutement.Entities.User.Notification;
import com.erecrutement.Repositories.CandidatRepository;
import com.erecrutement.Repositories.NotificationRepository;
import com.erecrutement.Repositories.RoleRepository;
import com.erecrutement.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ProjetV1Application {


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ProjetV1Application.class, args);

        //     UserRepository userRepository= ctx.getBean(UserRepository.class);
        CandidatRepository candidatRepository = ctx.getBean(CandidatRepository.class);
        NotificationRepository notificationRepository = ctx.getBean(NotificationRepository.class);

//        Notification n1 = new Notification();
//        n1.setId(1);
//        n1.setDescription("ok monsieur notification");
//        n1.setReceivedAt(new Date());
//        notificationRepository.save(n1);
//        Candidat c1 = candidatRepository.findByUsername("tsertsvadzesaba@gmail.com");
//        c1.getNotifications().add(n1);
//        candidatRepository.save(c1);
//        EntrepriseRepository entrepriseRepository = ctx.getBean(EntrepriseRepository.class);
//
        //        RoleRepository roleRepository = ctx.getBean(RoleRepository.class);

//        Role role1 = roleRepository.save(new Role("CANDIDAT", ""));
//        Role role2 = roleRepository.save(new Role("ENTREPRISE", ""));
//        roleRepository.save(new Role("ADMIN", ""));
//
//        Candidat candidat1 = candidatRepository.save(new Candidat("tsertsvadzesaba@gmail.com"
//                , "Saba", "Tsertsvadze", "123"));
//        candidat1.getRoles().add(role1);
//        candidatRepository.save(candidat1);
//
//        Entreprise entreprise1 = entrepriseRepository.save(new Entreprise("entreprise@truc.com"
//                , "Monsieur", "Madame", "123"));
//        entreprise1.getRoles().add(role2);
//        entrepriseRepository.save(entreprise1);
//
//        List<User> users = userRepository.findOne("tsertsvadzesaba@gmail.com");
//
//        users.forEach(user ->
//            System.out.println(user.getUsername() + " " + user.getPassword())
//        );

//        User user = userRepository.findByUsername("tsertsvadzesaba@gmail.com");
//
//        user.getRoles().forEach(role -> System.out.println(role.getRole()));
    }

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return (container -> {
//            //route all errors towards /error .
//            final ErrorPage errorPage=new ErrorPage("/error");
//            container.addErrorPages(errorPage);
//        });
//    }
}
