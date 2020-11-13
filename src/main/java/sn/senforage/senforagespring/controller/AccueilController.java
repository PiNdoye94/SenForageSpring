package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sn.senforage.senforagespring.entities.Client;
import sn.senforage.senforagespring.services.ClientsServices;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private ClientsServices cls;

    @GetMapping(value ="/")
    public String home(Model model){
        Client client = new Client();
        model.addAttribute("lclient", cls.findAllClient());
        model.addAttribute("snclient", client);
        return "Admin/admin";
    }
//    @GetMapping(value ="/new")
//    public String showNewClient(Model model){
//        Client client = new Client();
//        model.addAttribute("snclient", client);
//        return "Admin/admin";
//    }

    @PostMapping(value ="/save")
    public String newClient(@ModelAttribute("nclient") Client client, Model model){
        cls.saveClient(client);
        return "redirect:/";
    }
}
