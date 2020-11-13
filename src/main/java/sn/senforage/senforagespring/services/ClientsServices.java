package sn.senforage.senforagespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.senforage.senforagespring.dao.ClientRepository;
import sn.senforage.senforagespring.entities.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ClientsServices {
    @Autowired
    private ClientRepository clientRepository;

//    public List<Client> findAllClient(){
//        clientRepository.findAll();
//    }
    public Collection<Client> findAllClient(){
        List<Client> clients = new ArrayList<Client>();
        for (Client client : clientRepository.findAll()){
            clients.add(client);
        }
        return clients;
    }

    public Client getClient(Long id){
        return clientRepository.getOne(id);
    }
    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }
}
