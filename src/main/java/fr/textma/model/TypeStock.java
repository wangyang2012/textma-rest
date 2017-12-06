package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="te_typestock_tst")
public class TypeStock {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tst_id")
    private Integer id;

    @Column(name="tst_nom")
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
}
