package angelolaera.u5d5.runners;

import angelolaera.u5d5.entities.Edificio;
import angelolaera.u5d5.entities.Postazione;
import angelolaera.u5d5.entities.Prenotazione;
import angelolaera.u5d5.entities.Utente;
import angelolaera.u5d5.enums.TipoPostazione;
import angelolaera.u5d5.service.EdificioService;
import angelolaera.u5d5.service.PostazioneService;
import angelolaera.u5d5.service.PrenotazioneService;
import angelolaera.u5d5.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run (String... args){

        Edificio aulaMagna = new Edificio("Aula Magna","Via dei Ciliegi, 59","Noci");
        edificioService.creaEdificio(aulaMagna);

        Postazione openspace = new Postazione("Aula Openspace", TipoPostazione.OPENSPACE,100,aulaMagna);
        postazioneService.creaPostazione(openspace);

        Utente angelo = new Utente("angelolaera","Angelo","Laera","angelo.laera.1995@gmail.com");
        utenteService.creaUtente(angelo);

        Prenotazione prenotazione_1 = new Prenotazione(openspace,angelo,LocalDate.now());
        prenotazioneService.creaPrenotazione(prenotazione_1);

        List<Prenotazione> prenotazioni = prenotazioneService.trovaPrenotazioniPerUtenteEData(angelo, LocalDate.now());
        System.out.println("Prenotazioni trovate per utente e data: " + prenotazioni);
    }
}
