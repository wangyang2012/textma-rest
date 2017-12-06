package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="te_artcollection_acl")
public class CollectionArticle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="acl_id")
    private Integer id;

    @Column(name="acl_designation")
    private String designation;

    @ManyToOne
    @JoinColumn(name="acl_afa_id")
    private FamilleArticle famille;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
    }
}
