package sn.senforage.senforagespring.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.senforage.senforagespring.dao.UserRepository;
import sn.senforage.senforagespring.dao.VillageRepository;
import sn.senforage.senforagespring.entities.Client;
import sn.senforage.senforagespring.entities.User;
import sn.senforage.senforagespring.entities.Village;
import sn.senforage.senforagespring.services.UserServices;
import sn.senforage.senforagespring.services.VillageServices;
import java.util.List;
import java.util.Optional;

@Controller
public class SettingController {
    @Autowired
    private VillageRepository villageRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping(path = "/Settings")
    public String getAll(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name="size", defaultValue = "5") int size)
    {
        Page<Village> pageVillage = villageRepository.findAll(PageRequest.of(page,size));
        Page<User> pageUser = userRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("village", new Village());
        model.addAttribute("user", new User());
        model.addAttribute("lvillages", pageVillage.getContent());
        model.addAttribute("lusers", pageUser.getContent());
        model.addAttribute("pages", new int[pageVillage.getTotalPages()]);
        model.addAttribute("pages", new int[pageUser.getTotalPages()]);
        model.addAttribute("currentPage", page);
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

    @PostMapping(value = "/Settings/create")
    public String createOrUpdateVillage(Village village, User user)
    {
        villageRepository.save(village);
        userRepository.save(user);
        return "redirect:/Settings";
    }

    @GetMapping(path = "/Settings/delete/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id)
            throws NotFoundException
    {
        villageRepository.deleteById(id);
        userRepository.deleteById(id);
        return "redirect:/Settings";
    }

}
