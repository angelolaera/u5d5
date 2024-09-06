package angelolaera.u5d5.repositories;

import angelolaera.u5d5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EdificioRepository  extends JpaRepository <Edificio,Long> {

}
