package tn.esprit.tpautoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tpautoloc.domain.enums.CategorieVehicule;
import tn.esprit.tpautoloc.domain.enums.StatutVehicule;

import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicule;

    private String immatriculation;
    private String marque;
    private  String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // * vehicules <-> 1 agence
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="agence_id")
    private Agence agence;

    //1 vehicule <-> *reservation
    @OneToMany(mappedBy ="vehicule",fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();

    //1 vehicule <->*maintenance
    @OneToMany(mappedBy = "vehicule",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Set<Maintenance> maintenances = new HashSet<>();

    // * Vehicule ↔ * Equipement(proprio)
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="vehicule_equipement",
    joinColumns = @JoinColumn(name ="vehicule_id"),
    inverseJoinColumns =@JoinColumn(name="equipement_id")
    )
    private Set<Equipement> equipements = new HashSet<>();



}
