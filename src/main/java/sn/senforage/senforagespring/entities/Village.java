package sn.senforage.senforagespring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@ToString
public class Village implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String nomVillage;
    @OneToMany(mappedBy = "village")
    private Collection<Client> clients = new ArrayList<>();

    public Village() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomVillage() {
        return nomVillage;
    }

    public void setNomVillage(String nomVillage) {
        this.nomVillage = nomVillage;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    public Village(Long id, String nomVillage) {
        this.id = id;
        this.nomVillage = nomVillage;
    }
}
