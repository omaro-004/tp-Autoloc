package tn.esprit.tpautoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    private String libelle;

    //*equipement<->*vehicule
    @ManyToMany(mappedBy ="equipements")
    private Set<Vehicule> vehicules = new HashSet<>();
}