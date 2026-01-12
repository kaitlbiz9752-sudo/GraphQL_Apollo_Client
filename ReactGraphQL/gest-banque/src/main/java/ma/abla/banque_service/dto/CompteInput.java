package ma.abla.banque_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.abla.banque_service.entities.TypeCompte;

import java.time.LocalDate;

/**
 * DTO utilisé pour recevoir les données d'un compte lors des mutations GraphQL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteInput {
    private Double solde;
    private LocalDate dateCreation;
    private TypeCompte type;
}

