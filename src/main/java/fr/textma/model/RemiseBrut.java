package fr.textma.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="te_cliremise_clr")
public class RemiseBrut {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="clr_id")
    private Integer id;

    @Column(name="clr_cli_id")
    private Integer clientId;

    @Column(name="clr_afa_id")
    private Integer familleArticleId;

    @Column(name="clr_acl_id")
    private Integer collectionArticleId;

    @Column(name="clr_aga_id")
    private Integer gammeArticleId;

    @Column(name="clr_art_id")
    private Integer articleId;

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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getFamilleArticleId() {
        return familleArticleId;
    }

    public void setFamilleArticleId(Integer familleArticleId) {
        this.familleArticleId = familleArticleId;
    }

    public Integer getCollectionArticleId() {
        return collectionArticleId;
    }

    public void setCollectionArticleId(Integer collectionArticleId) {
        this.collectionArticleId = collectionArticleId;
    }

    public Integer getGammeArticleId() {
        return gammeArticleId;
    }

    public void setGammeArticleId(Integer gammeArticleId) {
        this.gammeArticleId = gammeArticleId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
