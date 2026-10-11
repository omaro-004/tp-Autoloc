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
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    // * maintenance<->1vehicule
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehicule_id")
    private Vehicule vehicule;
}