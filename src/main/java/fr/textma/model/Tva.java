package fr.textma.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ts_tva_tva")
public class Tva {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tva_id")
    private Integer id;

    @Column(name="tva_valeur")
    private BigDecimal valeur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
}
