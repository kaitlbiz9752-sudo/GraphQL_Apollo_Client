package ma.abla.banque_service.controllers;

import ma.abla.banque_service.dto.CompteInput;
import ma.abla.banque_service.dto.StatistiquesSolde;
import ma.abla.banque_service.entities.Compte;
import ma.abla.banque_service.exception.CompteNotFoundException;
import ma.abla.banque_service.repository.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

/**
 * Contrôleur GraphQL pour la gestion des comptes bancaires
 */
@Controller
@RequiredArgsConstructor
public class CompteControllerGraphQL {
    private final CompteRepository compteRepository;

    @QueryMapping
    public List<Compte> obtenirTousLesComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte recupererCompteParId(@Argument Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new CompteNotFoundException(
                        String.format("Aucun compte trouvé avec l'identifiant: %d", id)
                ));
    }

    @MutationMapping
    public Compte creerCompte(@Argument CompteInput input) {
        Compte nouveauCompte = new Compte();
        nouveauCompte.setSolde(input.getSolde() != null ? input.getSolde() : 0.0);
        nouveauCompte.setDateCreation(input.getDateCreation() != null ? input.getDateCreation() : LocalDate.now());
        nouveauCompte.setType(input.getType());
        return compteRepository.save(nouveauCompte);
    }

    @QueryMapping
    public StatistiquesSolde obtenirStatistiquesSoldes() {
        Long nombreTotal = compteRepository.count();
        Double totalSoldes = compteRepository.calculerTotalSoldes();
        Double moyenneSoldes = nombreTotal > 0 ? totalSoldes / nombreTotal : 0.0;

        return new StatistiquesSolde(nombreTotal, totalSoldes, moyenneSoldes);
    }
}