package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.senforage.senforagespring.dao.ClientRepository;
import sn.senforage.senforagespring.dao.VillageRepository;
import sn.senforage.senforagespring.entities.Client;
import sn.senforage.senforagespring.entities.Village;
import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VillageRepository villageRepository;

    @GetMapping(path = "/Accueil")
    public String home(Model model,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name="size", defaultValue = "5") int size,
                       @RequestParam(name="keyword", defaultValue = "") String mc) {

        Page<Client> pageClients = clientRepository.findByNomContains(mc, PageRequest.of(page,size));
        List<Village> listeVillages = villageRepository.findAll();
        model.addAttribute("client", new Client());
        model.addAttribute("lclients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("lvillages", listeVillages);
        model.addAttribute("keyword", mc);
        model.addAttribute("size", size);
        return "Admin/admin";

    }

    @PostMapping(value ="save")
    public String newClient(@ModelAttribute("nclient") Client client, Model model){
        clientRepository.save(client);
        return "redirect:/Accueil";
    }
}
