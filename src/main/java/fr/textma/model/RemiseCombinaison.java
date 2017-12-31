package fr.textma.model;

import javax.persistence.*;

/**
 * Created by ywang on 29/12/17.
 */
@Entity
public class RemiseCombinaison {
    @Id
    private String id;
    private Integer familleId;
    private String familleLibelle;
    private Integer collectionId;
    private String collectionLibelle;
    private Integer gammeId;
    private String gammeLibelle;
    private Integer count;
    private Integer articleId;
    private String articleLibelle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFamilleId() {
        return familleId;
    }

    public void setFamilleId(Integer familleId) {
        this.familleId = familleId;
    }

    public String getFamilleLibelle() {
        return familleLibelle;
    }

    public void setFamilleLibelle(String familleLibelle) {
        this.familleLibelle = familleLibelle;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionLibelle() {
        return collectionLibelle;
    }

    public void setCollectionLibelle(String collectionLibelle) {
        this.collectionLibelle = collectionLibelle;
    }

    public Integer getGammeId() {
        return gammeId;
    }

    public void setGammeId(Integer gammeId) {
        this.gammeId = gammeId;
    }

    public String getGammeLibelle() {
        return gammeLibelle;
    }

    public void setGammeLibelle(String gammeLibelle) {
        this.gammeLibelle = gammeLibelle;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleLibelle() {
        return articleLibelle;
    }

    public void setArticleLibelle(String articleLibelle) {
        this.articleLibelle = articleLibelle;
    }
}
