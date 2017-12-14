package fr.textma.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="te_article_art")
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="art_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="art_acl_id")
    private CollectionArticle collection;

    @Column(name="art_codearticle")
    private Integer codeArticle;

    @Column(name="art_designation")
    private String designation;

    @Column(name="art_prixvente")
    private BigDecimal prixVente;

    @Column(name="art_prixachat")
    private BigDecimal prixAchat;

    @Column(name="art_poids")
    private Float poids;

    @ManyToOne
    @JoinColumn(name="art_tva_id")
    private Tva tva;

    @Column(name="art_datecreation")
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name="art_aga_id")
    private GammeArticle gamme;

    @Column(name="art_metrelineaire")
    private Float metreLineaire;

    @Column(name="art_stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name="art_tis_id")
    private Tissu tissu;

    @Column(name="art_valeur")
    private BigDecimal valeur;

    @ManyToOne
    @JoinColumn(name="art_fou_id")
    private Fournisseur fournisseur;

    @Column(name="art_pourcentagefabrication")
    private BigDecimal pourcentageFabrication;

    @Column(name="art_pourcentagelocation")
    private BigDecimal pourcentageLocation;

    @Column(name="art_pourcentagelogistique")
    private BigDecimal pourcentageLogistique;

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

    public Integer getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(Integer codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Float getPoids() {
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public GammeArticle getGamme() {
        return gamme;
    }

    public void setGamme(GammeArticle gamme) {
        this.gamme = gamme;
    }

    public Float getMetreLineaire() {
        return metreLineaire;
    }

    public void setMetreLineaire(Float metreLineaire) {
        this.metreLineaire = metreLineaire;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Tissu getTissu() {
        return tissu;
    }

    public void setTissu(Tissu tissu) {
        this.tissu = tissu;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public BigDecimal getPourcentageFabrication() {
        return pourcentageFabrication;
    }

    public void setPourcentageFabrication(BigDecimal pourcentageFabrication) {
        this.pourcentageFabrication = pourcentageFabrication;
    }

    public BigDecimal getPourcentageLocation() {
        return pourcentageLocation;
    }

    public void setPourcentageLocation(BigDecimal pourcentageLocation) {
        this.pourcentageLocation = pourcentageLocation;
    }

    public BigDecimal getPourcentageLogistique() {
        return pourcentageLogistique;
    }

    public void setPourcentageLogistique(BigDecimal pourcentageLogistique) {
        this.pourcentageLogistique = pourcentageLogistique;
    }
}
