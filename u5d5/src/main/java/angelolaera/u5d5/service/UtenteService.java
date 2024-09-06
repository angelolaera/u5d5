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

    // Crea un nuovo utente
    public Utente creaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    // Recupera tutti gli utenti
    public List<Utente> trovaTuttiUtenti() {
        return utenteRepository.findAll();
    }

    // Trova un utente per ID
    public Utente trovaUtentePerId(Long id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }

    // Trova un utente per username
    public Utente trovaUtentePerUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    // Trova un utente per email
    public Utente trovaUtentePerEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    // Aggiorna un utente
    public Utente aggiornaUtente(Long id, Utente utenteAggiornato) {
        Utente utente = trovaUtentePerId(id);
        utente.setUsername(utenteAggiornato.getUsername());
        utente.setEmail(utenteAggiornato.getEmail());
        utente.setNome(utenteAggiornato.getNome());
        utente.setCognome(utenteAggiornato.getCognome());
        return utenteRepository.save(utente);
    }

    // Elimina un utente
    public void eliminaUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}
