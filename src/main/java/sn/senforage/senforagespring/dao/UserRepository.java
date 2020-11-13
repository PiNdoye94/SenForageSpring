package sn.senforage.senforagespring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.senforage.senforagespring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
