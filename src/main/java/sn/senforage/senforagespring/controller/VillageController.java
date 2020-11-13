package sn.senforage.senforagespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.senforage.senforagespring.dao.VillageRepository;
import sn.senforage.senforagespring.entities.Village;

@Controller
public class VillageController {

//    @Autowired
//    private VillageRepository villagedao;
//
//    @RequestMapping(value ="village", method= RequestMethod.POST)
//    //@PostMapping
//    public ModelAndView villageadd(String nomvillage){
//
//        ModelAndView modelAndView = new ModelAndView("Admin/settings");
//        Village village = new Village();
//        village.setNomVillage(nomvillage);
//        if (village.getNomVillage() != null) {
//            try{
//                villagedao.save(village);
//                villagedao.flush();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            //return new ModelAndView("Admin/settings");
//        }
//        return modelAndView;
//        //return "redirect: Settings";
 //   }
}
