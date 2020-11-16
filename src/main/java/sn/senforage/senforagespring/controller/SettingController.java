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
public class SettingController {
    @Autowired
    private VillageServices villageservice;
    @Autowired
    private UserServices userservice;


    @GetMapping("/Settings")
    public String getAll(Model model)
    {
        List<Village> listVillage = villageservice.getAllVillages();
        List<User> listUser = userservice.getAllUsers();
        model.addAttribute("villages", listVillage);
        model.addAttribute("users", listUser);
        return "Settings/list-village-user";
    }

    @GetMapping(path = {"/Settings/editVillage", "/Settings/editVillage/{id}"})
    public String editVillageById(Model model, @PathVariable("id") Optional<Long> id)
            throws NotFoundException
    {
//        if (id.isPresent()) {
//            Village editVillage = villageservice.getVillageById(id.get());
//            model.addAttribute("village", editVillage);
//        } else {
            model.addAttribute("village", new Village());
//        }
        return "Settings/add-edit-village";
    }

    @GetMapping(path = {"/Settings/editUser", "/Settings/editUser/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id)
            throws NotFoundException
    {
        //if (id.isPresent()) {
           // User editUser = userservice.getUserById(id.get());
          //  model.addAttribute("user", editUser);
       // } else {
            model.addAttribute("user", new User());
       // }
        return "Settings/add-edit-user";
    }

    @PostMapping(path = "/Settings/create")
    public String createOrUpdateVillage(Village village, User user)
    {
        villageservice.createOrUpdateVillage(village);
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

}
