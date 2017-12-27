package fr.textma.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="te_formejuridique_fju")
public class FormeJuridique {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fju_id")
    private Integer id;

    @Column(name="fju_nom")
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getValue() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setValue(String value) {
        this.nom = value;
    }
}
