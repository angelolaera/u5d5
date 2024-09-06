package angelolaera.u5d5.repositories;

import angelolaera.u5d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    // Trova un utente per username
    Utente findByUsername(String username);

    // Trova un utente per email
    Utente findByEmail(String email);
}
