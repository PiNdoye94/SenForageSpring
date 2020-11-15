package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sn.senforage.senforagespring.entities.Client;
import sn.senforage.senforagespring.services.ClientsServices;

import java.util.Collection;

@Controller
public class ClientController {

    @Autowired
    private ClientsServices clientsServices;

    @GetMapping(value ="/Table")
    public String client(Model model){
        Client client = new Client();
        //ModelAndView mav = new ModelAndView();
        model.addAttribute("tClient",clientsServices.findAllClient());
        model.addAttribute("slclient", client);
        return "Client/tables";
    }

//    @GetMapping(value ="/Table-Clients")
//    public Collection<Client> getClient(){
//        return clientsServices.findAllClient();
//    }

    @GetMapping(value ="/Table-Clients/delete")
    public void deleteClient(@RequestParam Long id){
        clientsServices.delete(id);
    }

    @GetMapping(value ="/Table-Clients/edit/{id}")
    public ModelAndView editClient(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("admin");
        Client client = clientsServices.getClient(id);
        mav.addObject("eclient", client);
        return mav;

        
    }
}
