package angelolaera.u5d5.repositories;

import angelolaera.u5d5.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoPostazioneAndEdificio_Citta(String tipoPostazione, String citta);
    Postazione findByCodice(String codice);
}
