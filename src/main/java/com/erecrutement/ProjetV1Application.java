package com.erecrutement;

import com.erecrutement.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjetV1Application {



	public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ProjetV1Application.class, args);

//        RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
   //     UserRepository userRepository= ctx.getBean(UserRepository.class);
//        CandidatRepository candidatRepository = ctx.getBean(CandidatRepository.class);
//        EntrepriseRepository entrepriseRepository = ctx.getBean(EntrepriseRepository.class);
//
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
}
