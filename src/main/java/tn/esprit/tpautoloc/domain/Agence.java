package tn.esprit.tpautoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;
    //1 agence <-> * employees
    @OneToMany(mappedBy ="agence", cascade =CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employees=new HashSet<>();

    //1 agence<-> * voitures
    @OneToMany(mappedBy ="agence",fetch =FetchType.LAZY)
    private Set<Vehicule> vehicules =new HashSet<>();
}
