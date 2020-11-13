//package sn.senforage.senforagespring.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import sn.senforage.senforagespring.dao.VillageRepository;
//import sn.senforage.senforagespring.entities.Village;
//import org.springframework.data.domain.Pageable;
//import sn.senforage.senforagespring.exception.BadResourceException;
//import sn.senforage.senforagespring.exception.ResourceAlreadyExistsException;
//import sn.senforage.senforagespring.exception.ResourceNotFoundException;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class VillageServices {
//
//    @Autowired
//    private VillageRepository villageRepository;
//
//    private boolean existsById(Long id) {
//        return villageRepository.existsById(id);
//    }
//
//    public Village findById(Long id) throws ResourceNotFoundException {
//        Village village = villageRepository.findById(id).orElse(null);
//        if (village==null) {
//            throw new ResourceNotFoundException("Cannot find village with id: " + id);
//        }
//        else return village;
//    }
//
//    public List<Village> findAll(int pageNumber, int rowPerPage) {
//        List<Village> village = new ArrayList<>();
//        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
//                Sort.by("id").ascending());
//        villageRepository.findAll(sortedByIdAsc).forEach(village::add);
//        return village;
//    }
//
//    public Village save(Village village) throws BadResourceException, ResourceAlreadyExistsException {
//        if (!StringUtils.isEmpty(village.getNomVillage())) {
//            if (village.getId() != null && existsById(village.getId())) {
//                throw new ResourceAlreadyExistsException("Village with id: " + village.getId() +
//                        " already exists");
//            }
//            return villageRepository.save(village);
//        }
//        else {
//            BadResourceException exc = new BadResourceException("Failed to save village");
//            exc.addErrorMessage("Village is null or empty");
//            throw exc;
//        }
//    }
//
//    public void update(Village village)
//            throws BadResourceException, ResourceNotFoundException {
//        if (!StringUtils.isEmpty(village.getNomVillage())) {
//            if (!existsById(village.getId())) {
//                throw new ResourceNotFoundException("Cannot find Village with id: " + village.getId());
//            }
//            villageRepository.save(village);
//        }
//        else {
//            BadResourceException exc = new BadResourceException("Failed to save village");
//            exc.addErrorMessage("Village is null or empty");
//            throw exc;
//        }
//    }
//
//    public void deleteById(Long id) throws ResourceNotFoundException {
//        if (!existsById(id)) {
//            throw new ResourceNotFoundException("Cannot find village with id: " + id);
//        }
//        else {
//            villageRepository.deleteById(id);
//        }
//    }
//
//    public Long count() {
//        return villageRepository.count();
//    }
//}
