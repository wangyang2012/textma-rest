package fr.textma.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="te_cliremise_clr")
public class Remise {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="clr_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="clr_cli_id")
    private TeClient client;

    @ManyToOne
    @JoinColumn(name="clr_afa_id")
    private FamilleArticle famille;

    @ManyToOne
    @JoinColumn(name="clr_acl_id")
    @Where(clause = "clr_acl_id > 0")
    private CollectionArticle collection;

    @ManyToOne
    @JoinColumn(name="clr_aga_id")
    @Where(clause = "clr_aga_id > 0")
    private GammeArticle gamme;

    @ManyToOne
    @JoinColumn(name="clr_art_id")
    @Where(clause = "clr_art_id > 0")
    private Article article;

    @Column(name="clr_remise")
    private BigDecimal remise;

    @Column(name="clr_remiseprix")
    private BigDecimal prix;

    @Column(name="clr_remiserotationpourcentage")
    private BigDecimal rotationPourcentage;

    @Column(name="clr_remiserotationprix")
    private BigDecimal rotationPrix;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeClient getClient() {
        return client;
    }

    public void setClient(TeClient client) {
        this.client = client;
    }

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getRotationPourcentage() {
        return rotationPourcentage;
    }

    public void setRotationPourcentage(BigDecimal rotationPourcentage) {
        this.rotationPourcentage = rotationPourcentage;
    }

    public BigDecimal getRotationPrix() {
        return rotationPrix;
    }

    public void setRotationPrix(BigDecimal rotationPrix) {
        this.rotationPrix = rotationPrix;
    }

    public String getLibelle() {
        if (famille != null) {
            return famille.getLibelle();
        }

        if (collection != null) {
            return collection.getDesignation();
        }

        if (gamme != null) {
            return gamme.getDesignation();
        }

        if (article != null) {
            return article.getDesignation();
        }
        return "";
    }
}
