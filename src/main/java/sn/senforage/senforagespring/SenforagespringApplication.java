package sn.senforage.senforagespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sn.senforage.senforagespring.dao.ProfilRepository;
import sn.senforage.senforagespring.dao.UserRepository;
import sn.senforage.senforagespring.entities.Profil;
import sn.senforage.senforagespring.entities.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SenforagespringApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SenforagespringApplication.class, args);

//        Profil profils = new Profil();
//        profils.setId(1L);
//        profils.setNomProfil("User_Profil");
//
//        User user = new User();
//        user.setId(1L);
//        user.setNom("Ndoye");
//        user.setPrenom("Pisco");
//        user.setUsername("piscondoye@gmail.com");
//        user.setPassword("12345");
//
//        List<Profil> profil = new ArrayList<>();
//        profil.add(profils);
//        user.setProfils(profil);
//        UserRepository iUser = ctx.getBean(UserRepository.class);
//        try {
//            iUser.saveAndFlush(user);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

//        ProfilRepository iProfil = ctx.getBean(ProfilRepository.class);
//        try {
//            iProfil.saveAndFlush(profils);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

//        UserRepository iUser = ctx.getBean(UserRepository.class);
//        User user = new User();
//        user.setId(1L);
//        user.setNom("Ndoye");
//        user.setPrenom("Papis");
//        user.setUsername("papisndoye218@gmail.com");
//        user.setPassword("12345");
//
//        try {
//            iUser.saveAndFlush(user);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

    }


}
