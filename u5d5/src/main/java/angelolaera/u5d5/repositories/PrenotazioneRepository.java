package angelolaera.u5d5.repositories;

import angelolaera.u5d5.entities.Postazione;
import angelolaera.u5d5.entities.Prenotazione;
import angelolaera.u5d5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface PrenotazioneRepository extends JpaRepository <Prenotazione,Long> {

    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtente(Utente utente);

}
