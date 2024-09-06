package angelolaera.u5d5.service;

import angelolaera.u5d5.entities.Utente;
import angelolaera.u5d5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente creaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public List<Utente> trovaTuttiUtenti() {
        return utenteRepository.findAll();
    }

    public Utente trovaUtentePerId(Long id) {
        return utenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }

    public Utente trovaUtentePerUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    public Utente trovaUtentePerEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    public Utente aggiornaUtente(Long id, Utente utenteAggiornato) {
        Utente utente = trovaUtentePerId(id);
        utente.setUsername(utenteAggiornato.getUsername());
        utente.setEmail(utenteAggiornato.getEmail());
        utente.setNome(utenteAggiornato.getNome());
        utente.setCognome(utenteAggiornato.getCognome());
        return utenteRepository.save(utente);
    }

    public void eliminaUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}
