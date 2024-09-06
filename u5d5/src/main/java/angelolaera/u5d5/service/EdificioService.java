package angelolaera.u5d5.service;

import angelolaera.u5d5.entities.Edificio;
import angelolaera.u5d5.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio creaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public List<Edificio> trovaTuttiEdifici() {
        return edificioRepository.findAll();
    }

    public Edificio trovaEdificioPerId(Long id) {
        return edificioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Edificio non trovato"));
    }

    public Edificio trovaEdificioPerCitta(String citta) {
        return edificioRepository.findByCitta(citta);
    }

    public Edificio aggiornaEdificio(Long id, Edificio edificioAggiornato) {
        Edificio edificio = trovaEdificioPerId(id);
        edificio.setNome(edificioAggiornato.getNome());
        edificio.setIndirizzo(edificioAggiornato.getIndirizzo());
        edificio.setCitta(edificioAggiornato.getCitta());
        return edificioRepository.save(edificio);
    }

    public void eliminaEdificio(Long id) {
        edificioRepository.deleteById(id);
    }
}
