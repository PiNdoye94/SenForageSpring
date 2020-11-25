package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sn.senforage.senforagespring.dao.ClientRepository;
import sn.senforage.senforagespring.entities.Client;
import sn.senforage.senforagespring.entities.Village;

import java.util.Collection;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path ="/Table")
    public String client(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name="size", defaultValue = "5") int size){
        Page<Client> pageClients = clientRepository.findAll(PageRequest.of(page,size));

        //model.addAttribute("client", new Client());
        model.addAttribute("tableClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);

        return "Client/list-client";
    }

   @GetMapping(path ="/deleteClient")
    public String delete(Long id){
        clientRepository.deleteById(id);

        return "redirect:/Table";
    }
/*
    @GetMapping(value ="/Table-Clients/edit/{id}")
    public ModelAndView editClient(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("admin");
        Client client = clientRepository.findById(id);
        mav.addObject("eclient", client);
        return mav;

        
    }*/
}
