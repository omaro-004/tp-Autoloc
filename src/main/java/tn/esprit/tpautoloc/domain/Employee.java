package tn.esprit.tpautoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tpautoloc.domain.enums.RoleEmployee;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmployee role;
}