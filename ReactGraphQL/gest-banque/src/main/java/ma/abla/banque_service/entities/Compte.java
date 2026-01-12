package ma.abla.banque_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entité représentant un compte bancaire dans le système
 */
@Entity
@Table(name = "comptes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compte_id")
    private Long id;
    
    @Column(name = "montant_solde", nullable = false)
    private Double solde;

    @Column(name = "date_ouverture")
    private LocalDate dateCreation;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie_compte", nullable = false)
    private TypeCompte type;
}