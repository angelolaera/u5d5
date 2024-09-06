package angelolaera.u5d5.service;

import angelolaera.u5d5.entities.Postazione;
import angelolaera.u5d5.entities.Prenotazione;
import angelolaera.u5d5.entities.Utente;
import angelolaera.u5d5.repositories.PostazioneRepository;
import angelolaera.u5d5.repositories.PrenotazioneRepository;
import angelolaera.u5d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public Prenotazione prenotaPostazione(Long postazioneId, Long utenteId, LocalDate data) {
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new RuntimeException("Postazione non trovata"));
        Utente utente = utenteRepository.findById(utenteId).orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (!prenotazioneRepository.findByPostazioneAndData(postazione, data).isEmpty()) {
            throw new RuntimeException("Postazione già prenotata per la data specificata");
        }

        if (!prenotazioneRepository.findByUtenteAndData(utente, data).isEmpty()) {
            throw new RuntimeException("L'utente ha già una prenotazione per la data specificata");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);
        prenotazione.setData(data);
        return prenotazioneRepository.save(prenotazione);
    }

    // Recupera tutte le prenotazioni
    public List<Prenotazione> trovaTuttePrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    // Trova prenotazioni per utente
    public List<Prenotazione> trovaPrenotazioniPerUtente(Long utenteId) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow(() -> new RuntimeException("Utente non trovato"));
        return prenotazioneRepository.findByUtenteAndData(utente,data);
    }

    // Cancella una prenotazione
    public void cancellaPrenotazione(Long prenotazioneId) {
        prenotazioneRepository.deleteById(prenotazioneId);
    }
}

