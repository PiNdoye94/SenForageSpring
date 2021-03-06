package sn.senforage.senforagespring.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.senforage.senforagespring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Page<Client> findByNomContains(String mc, Pageable pageable);
}
