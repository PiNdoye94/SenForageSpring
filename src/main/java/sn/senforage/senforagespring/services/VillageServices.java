package sn.senforage.senforagespring.services;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import sn.senforage.senforagespring.dao.VillageRepository;
import sn.senforage.senforagespring.entities.Village;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VillageServices {

    @Autowired
    private VillageRepository villageRepository;

    public Village createOrUpdateVillage(Village village)
    {
        if(village.getId()  == null)
        {
            village = villageRepository.save(village);

            return village;
        }
        else
        {
            Optional<Village> vlg = villageRepository.findById(village.getId());

            if(vlg.isPresent())
            {
                Village newVillage = vlg.get();
                newVillage.setNomVillage(village.getNomVillage());

                newVillage = villageRepository.save(newVillage);

                return newVillage;
            } else {
                village = villageRepository.save(village);

                return village;
            }
        }
    }

    public List<Village> getAllVillages()
    {
        List<Village> result = (List<Village>) villageRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Village>();
        }
    }

    public Village getVillageById(Long id) throws NotFoundException
    {
        Optional<Village> village = villageRepository.findById(id);

        if(village.isPresent()) {
            return village.get();
        } else {
            throw new NotFoundException("Ce village n'existe pas!!");
        }
    }

    public void deleteVillageById(Long id) throws NotFoundException
    {
        Optional<Village> village = villageRepository.findById(id);

        if(village.isPresent())
        {
            villageRepository.deleteById(id);
        } else {
            throw new NotFoundException("Ce village n'existe pas!!");
        }
    }

}
