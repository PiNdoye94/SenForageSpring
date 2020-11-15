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
@ToString
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

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Profil> getProfils() {
        return profils;
    }

    public void setProfils(List<Profil> profils) {
        this.profils = profils;
    }

    public User(Long id, String nom, String prenom, String username, String password, List<Profil> profils) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.profils = profils;
    }
}
