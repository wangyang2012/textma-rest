package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="te_fonctioncontact_fon")
public class TeFonctionContact {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fon_id")
    private Integer id;

    @Column(name="fon_intitule")
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getValue() {
        return nom;
    }
}
