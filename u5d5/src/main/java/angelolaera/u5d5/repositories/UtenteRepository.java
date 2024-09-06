package angelolaera.u5d5.repositories;

import angelolaera.u5d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UtenteRepository extends JpaRepository <Utente,Long> {

    Optional<Utente> findByUsername(String username);

}
