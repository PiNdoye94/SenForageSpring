package sn.senforage.senforagespring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    @ManyToMany(
            cascade=CascadeType.ALL,fetch=FetchType.EAGER
    )
    @JoinTable(name="users_profils",
            joinColumns = {
                    @JoinColumn(name="users", referencedColumnName="username")},
            inverseJoinColumns = {
                    @JoinColumn(name="profils", referencedColumnName="nomProfil")}
    )
    private List<Profil> profils = new ArrayList<>();
}
