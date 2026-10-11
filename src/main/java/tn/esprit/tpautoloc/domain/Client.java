package tn.esprit.tpautoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    //1 client <-> * reservation
    @OneToMany(mappedBy ="client" , cascade=CascadeType.PERSIST , fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();
}