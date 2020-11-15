package sn.senforage.senforagespring.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.senforage.senforagespring.dao.UserRepository;
import sn.senforage.senforagespring.dao.VillageRepository;
import sn.senforage.senforagespring.entities.User;
import sn.senforage.senforagespring.entities.Village;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User createOrUpdateUser(User user)
    {
        if(user.getId()  == null)
        {
            user = userRepository.save(user);

            return user;
        }
        else
        {
            Optional<User> users = userRepository.findById(user.getId());

            if(users.isPresent())
            {
                User newUser = users.get();
                newUser.setNom(user.getNom());
                newUser.setPrenom(user.getPrenom());
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());

                newUser = userRepository.save(newUser);

                return newUser;
            } else {
                user = userRepository.save(user);

                return user;
            }
        }
    }

    public List<User> getAllUsers()
    {
        List<User> result = (List<User>) userRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(Long id) throws NotFoundException
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new NotFoundException("Cet utilisateur n'existe pas!!");
        }
    }

    public void deleteUserById(Long id) throws NotFoundException
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
        {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("Cet utilisateur n'existe pas!!");
        }
    }
}
