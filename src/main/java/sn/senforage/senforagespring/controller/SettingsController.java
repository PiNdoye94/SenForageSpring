package sn.senforage.senforagespring.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.senforage.senforagespring.entities.User;
import sn.senforage.senforagespring.entities.Village;
import sn.senforage.senforagespring.services.UserServices;
import sn.senforage.senforagespring.services.VillageServices;


import java.util.List;
import java.util.Optional;

@Controller
public class SettingsController {
    @Autowired
    private VillageServices villageservice;
    @Autowired
    private UserServices userservice;

//
//    @Autowired
//    public SettingsController(VillageRepository villagedao) {
//        this.villagedao = villagedao;
//    }

    @GetMapping("/Settings")
    public String getAll(Model model)
    {
        List<Village> listVillage = villageservice.getAllVillages();
        List<User> listUser = userservice.getAllUsers();
        model.addAttribute("villages", listVillage);
        model.addAttribute("users", listUser);
        return ("Admin/settings");
    }

    @GetMapping(path = {"/Settings/edit", "/Settings/edit/{id}"})
    public String editById(Model model, @PathVariable("id") Optional<Long> id)
            throws NotFoundException
    {
        if (id.isPresent()) {
            Village editVillage = villageservice.getVillageById(id.get());
            User editUser = userservice.getUserById(id.get());
            model.addAttribute("village", editVillage);
            model.addAttribute("user", editUser);
        } else {
            model.addAttribute("village", new Village());
            model.addAttribute("user", new User());
        }
        return ("Admin/settings");
    }

    @PostMapping("/Settings/create")
    public String createOrUpdateVillage(Village village)
    {
        villageservice.createOrUpdateVillage(village);
        return "redirect:/Settings";
    }

    @PostMapping("/Settings/create/user")
    public String createOrUpdateUser(User user)
    {
        userservice.createOrUpdateUser(user);
        return "redirect:/Settings";
    }

    @GetMapping(path = "/Settings/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id)
            throws NotFoundException
    {
        villageservice.deleteVillageById(id);
        userservice.deleteUserById(id);
        return "redirect:/Settings";
    }



   /* @PostMapping("/Settings")
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
    }*/

}
