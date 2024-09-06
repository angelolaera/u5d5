package angelolaera.u5d5.entities;

import angelolaera.u5d5.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="postazione")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codice;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione(String codice, String descrizione, TipoPostazione tipoPostazione, int numeroMassimoOccupanti, Edificio edificio) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.edificio = edificio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoPostazione getTipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(TipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public int getNumeroMassimoOccupanti() {
        return numeroMassimoOccupanti;
    }

    public void setNumeroMassimoOccupanti(int numeroMassimoOccupanti) {
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
