package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="te_artgamme_aga")
public class GammeArticle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="aga_id")
    private Integer id;

    @Column(name="aga_designation")
    private String designation;

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
}
