//package sn.senforage.senforagespring.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//@Entity
//@Data @NoArgsConstructor @AllArgsConstructor @ToString
//public class Profil implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nomProfil;
//    @ManyToMany(fetch = FetchType.LAZY,
//        cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//            },
//             mappedBy = "profils")
//    private List<User> user = new ArrayList<>();
//}
