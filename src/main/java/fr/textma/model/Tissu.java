package fr.textma.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="te_tissu_tis")
public class Tissu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tis_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="tis_acl_id")
    private CollectionArticle collection;

    @ManyToOne
    @JoinColumn(name="tis_aga_id")
    private GammeArticle gamme;

    @Column(name="tis_designation")
    private String designation;

    @Column(name="tis_quantite")
    private Float quantite;

    @Column(name="tis_prix")
    private BigDecimal prix;

    @Column(name="tis_largeur")
    private Float largeur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CollectionArticle getCollection() {
        return collection;
    }

    public void setCollection(CollectionArticle collection) {
        this.collection = collection;
    }

    public GammeArticle getGamme() {
        return gamme;
    }

    public void setGamme(GammeArticle gamme) {
        this.gamme = gamme;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Float getLargeur() {
        return largeur;
    }

    public void setLargeur(Float largeur) {
        this.largeur = largeur;
    }
}
