package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sn.senforage.senforagespring.dao.ProfilRepository;
import sn.senforage.senforagespring.dao.UserRepository;
import sn.senforage.senforagespring.dao.VillageRepository;
import sn.senforage.senforagespring.entities.Profil;
import sn.senforage.senforagespring.entities.User;
import sn.senforage.senforagespring.entities.Village;


import java.util.List;

@Controller
public class SettingsController {
    @Autowired
    private VillageRepository villagedao;
//    @Autowired
//    private ProfilRepository profildao;
    @Autowired
    private UserRepository userdao;

    @Autowired
    public SettingsController(VillageRepository villagedao) {
        this.villagedao = villagedao;
    }

    @PostMapping("/Settings")
    public String villageadd(@ModelAttribute("villageform") Village village, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "add-student";
        }

        villagedao.save(village);
        return "redirect: /Settings";
    }

    @GetMapping("/Settings")
    public String villagelist(Model model){

        List<Village> village = villagedao.findAll();
        List<User> user = userdao.findAll();
        //List<Profil> profil = profildao.findAll();

        model.addAttribute("newV", village);
        model.addAttribute("newU", user);
        //model.addAttribute("newP", profil);

        return ("Admin/settings");
    }

}
