package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="ts_commercialinterne_coi")
public class CommercialInterne {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="coi_id")
    private Integer id;

    @Column(name = "coi_code")
    private String code;

    @Column(name="coi_nom")
    private String nom;

    @Column(name="coi_prenom")
    private String prenom;

    @Column(name="coi_civilite")
    private String civilite;

    @Column(name="coi_telephone")
    private String telephone;

    @Column(name="coi_fonction")
    private String fonction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getValue() {
        String civilite = getCivilite() == null ? "" : getCivilite();
        String nom = getNom() == null ? "" : getNom();
        String prenom = getPrenom() == null ? "" : getPrenom();
        return civilite + " " + nom + " " + prenom;
    }
}
