package ma.abla.banque_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO représentant les statistiques agrégées des soldes de comptes
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatistiquesSolde {
    private Long nombreComptes;
    private Double totalSoldes;
    private Double moyenneSoldes;
}

