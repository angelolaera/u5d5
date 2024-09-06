package angelolaera.u5d5.service;

import angelolaera.u5d5.entities.Prenotazione;
import angelolaera.u5d5.entities.Postazione;
import angelolaera.u5d5.entities.Utente;
import angelolaera.u5d5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> trovaTuttePrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public List<Prenotazione> trovaPrenotazioniPerUtenteEData(Utente utente, LocalDate data) {
        return prenotazioneRepository.findByUtenteAndData(utente, data);
    }

    public List<Prenotazione> trovaPrenotazioniPerPostazioneEData(Postazione postazione, LocalDate data) {
        return prenotazioneRepository.findByPostazioneAndData(postazione, data);
    }

    public List<Prenotazione> trovaPrenotazioniPerPostazione(Postazione postazione) {
        return prenotazioneRepository.findByPostazione(postazione);
    }

    public Prenotazione trovaPrenotazionePerId(Long id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Prenotazione non trovata"));
    }

    public Prenotazione aggiornaPrenotazione(Long id, Prenotazione prenotazioneAggiornata) {
        Prenotazione prenotazione = trovaPrenotazionePerId(id);
        prenotazione.setPostazione(prenotazioneAggiornata.getPostazione());
        prenotazione.setUtente(prenotazioneAggiornata.getUtente());
        prenotazione.setData(prenotazioneAggiornata.getData());
        return prenotazioneRepository.save(prenotazione);
    }

    public void eliminaPrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
