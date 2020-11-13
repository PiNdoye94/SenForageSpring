package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sn.senforage.senforagespring.entities.Client;
import sn.senforage.senforagespring.services.ClientsServices;

import java.util.Collection;

@RestController
public class ClientController {

    @Autowired
    private ClientsServices clientsServices;

    @GetMapping(value ="/Table-Clients")
    public ModelAndView client(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("tClient",clientsServices.findAllClient());
        return mav;
    }

//    @GetMapping(value ="/Table-Clients")
//    public Collection<Client> getClient(){
//        return clientsServices.findAllClient();
//    }

    @GetMapping(value ="/Table-Clients/delete")
    public void deleteClient(@RequestParam Long id){
        clientsServices.delete(id);
    }
}
