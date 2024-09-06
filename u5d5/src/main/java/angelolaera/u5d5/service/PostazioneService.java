package angelolaera.u5d5.service;

import angelolaera.u5d5.entities.Edificio;
import angelolaera.u5d5.entities.Postazione;
import angelolaera.u5d5.repositories.EdificioRepository;
import angelolaera.u5d5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    public Postazione creaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> trovaTuttePostazioni() {
        return postazioneRepository.findAll();
    }

    public List<Postazione> trovaPostazioniPerTipoECitta(String tipoPostazione, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipoPostazione, citta);
    }

    public Postazione trovaPostazionePerId(Long id) {
        return postazioneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postazione non trovata"));
    }

    public Postazione aggiornaPostazione(Long id, Postazione postazioneAggiornata) {
        Postazione postazione = trovaPostazionePerId(id);
        postazione.setDescrizione(postazioneAggiornata.getDescrizione());
        postazione.setTipoPostazione(postazioneAggiornata.getTipoPostazione());
        postazione.setNumeroMassimoOccupanti(postazioneAggiornata.getNumeroMassimoOccupanti());
        return postazioneRepository.save(postazione);
    }

    public void eliminaPostazione(Long id) {
        postazioneRepository.deleteById(id);
    }
}
