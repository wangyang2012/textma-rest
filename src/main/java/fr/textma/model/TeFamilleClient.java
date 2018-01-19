package fr.textma.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "te_clifamille_clf")
public class TeFamilleClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clf_id")
    private Integer id;

    @Column(name = "clf_nom")
    private String nom;

    @Formula("(select COALESCE(count(*), 0) from te_client_cli cli where cli.cli_clf_id=clf_id )")
    private Integer nbClients;


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

    public void setValue(String nom) {
        this.nom = nom;
    }

    public Integer getNbClients() {
        return nbClients;
    }

    public void setNbClients(Integer nbClients) {
        this.nbClients = nbClients;
    }
}
