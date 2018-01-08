package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="ts_modepaiement_mpa")
public class TsModePaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpa_id")
    private Integer id;

    @Column(name = "mpa_code")
    private String code;

    @Column(name = "mpa_libelle")
    private String libelle;

    @Column(name = "mpa_type")
    private String type;

    @Column(name = "mpa_mois")
    private Integer mois;

    @Column(name = "mpa_findemois")
    private Boolean finDeMois;

    @Column(name = "mpa_jour")
    private Integer jour;

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Boolean getFinDeMois() {
        return finDeMois;
    }

    public void setFinDeMois(Boolean finDeMois) {
        this.finDeMois = finDeMois;
    }

    public Integer getJour() {
        return jour;
    }

    public void setJour(Integer jour) {
        this.jour = jour;
    }

    public String getValue() {
        return code + " - " + libelle + " - " + type;
    }
}