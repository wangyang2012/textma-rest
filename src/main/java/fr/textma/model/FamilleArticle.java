package fr.textma.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="te_artfamille_afa")
public class FamilleArticle {


    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="afa_id")
    private Integer id;

    @Column(name="afa_libelle")
    private String libelle;

    @ManyToOne
    @JoinColumn(name="afa_tst_id")
    private TypeStock typeStock;

    @OneToMany(mappedBy = "famille")
    private List<CollectionArticle> collections;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeStock getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(TypeStock typeStock) {
        this.typeStock = typeStock;
    }

    public List<CollectionArticle> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionArticle> collections) {
        this.collections = collections;
    }
}
