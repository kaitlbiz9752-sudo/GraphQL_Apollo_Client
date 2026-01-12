package ma.abla.banque_service.repository;

import ma.abla.banque_service.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository pour l'accès aux données des comptes bancaires
 */
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    /**
     * Calcule la somme totale de tous les soldes des comptes
     * @return la somme totale des soldes, ou 0.0 si aucun compte n'existe
     */
    @Query("SELECT COALESCE(SUM(c.solde), 0.0) FROM Compte c")
    Double calculerTotalSoldes();
}
