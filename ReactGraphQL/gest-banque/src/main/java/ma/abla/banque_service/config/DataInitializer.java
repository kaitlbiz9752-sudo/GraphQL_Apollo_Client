package ma.abla.banque_service.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.abla.banque_service.entities.Compte;
import ma.abla.banque_service.entities.TypeCompte;
import ma.abla.banque_service.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Classe d'initialisation des données qui crée des comptes de test au démarrage de l'application
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CompteRepository compteRepository;

    @Override
    public void run(String... args) {
        if (compteRepository.count() == 0) {
            log.info("Initialisation des données de test...");

            Compte compte1 = new Compte();
            compte1.setSolde(5000.0);
            compte1.setDateCreation(LocalDate.of(2024, 1, 15));
            compte1.setType(TypeCompte.COURANT);
            compteRepository.save(compte1);

            Compte compte2 = new Compte();
            compte2.setSolde(12000.0);
            compte2.setDateCreation(LocalDate.of(2024, 3, 20));
            compte2.setType(TypeCompte.EPARGNE);
            compteRepository.save(compte2);

            Compte compte3 = new Compte();
            compte3.setSolde(2500.0);
            compte3.setDateCreation(LocalDate.of(2024, 5, 10));
            compte3.setType(TypeCompte.COURANT);
            compteRepository.save(compte3);

            Compte compte4 = new Compte();
            compte4.setSolde(8000.0);
            compte4.setDateCreation(LocalDate.of(2024, 7, 5));
            compte4.setType(TypeCompte.EPARGNE);
            compteRepository.save(compte4);

            Compte compte5 = new Compte();
            compte5.setSolde(15000.0);
            compte5.setDateCreation(LocalDate.now());
            compte5.setType(TypeCompte.COURANT);
            compteRepository.save(compte5);

            log.info("{} comptes créés avec succès", compteRepository.count());
        } else {
            log.info("Les données existent déjà ({} comptes trouvés)", compteRepository.count());
        }
    }
}

