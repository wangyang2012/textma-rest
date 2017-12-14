package fr.textma.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="te_cliremise_clr")
public class Remise {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="clr_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="clr_cli_id")
    private TeClient client;

    @ManyToOne
    @JoinColumn(name="clr_afa_id")
    private FamilleArticle familleArticle;

    @ManyToOne
    @JoinColumn(name="clr_acl_id")
    private CollectionArticle collectionArticle;

    @ManyToOne
    @JoinColumn(name="clr_aga_id")
    private GammeArticle gammeArticle;

    @Column(name="clr_remise")
    private BigDecimal remise;

    @Column(name="clr_remiseprix")
    private BigDecimal prix;

    @Column(name="clr_remiserotationpourcentage")
    private BigDecimal rotationPourcentage;

    @Column(name="clr_remiserotationprix")
    private BigDecimal retationPrix;

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

    public FamilleArticle getFamilleArticle() {
        return familleArticle;
    }

    public void setFamilleArticle(FamilleArticle familleArticle) {
        this.familleArticle = familleArticle;
    }

    public CollectionArticle getCollectionArticle() {
        return collectionArticle;
    }

    public void setCollectionArticle(CollectionArticle collectionArticle) {
        this.collectionArticle = collectionArticle;
    }

    public GammeArticle getGammeArticle() {
        return gammeArticle;
    }

    public void setGammeArticle(GammeArticle gammeArticle) {
        this.gammeArticle = gammeArticle;
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

    public BigDecimal getRetationPrix() {
        return retationPrix;
    }

    public void setRetationPrix(BigDecimal retationPrix) {
        this.retationPrix = retationPrix;
    }
}
