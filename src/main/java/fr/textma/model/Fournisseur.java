package fr.textma.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="te_fournisseur_fou")
public class Fournisseur {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fou_id")
    private Integer id;

    @Column(name="fou_codefournisseur")
    private Integer code;

    @Column(name="fou_societe")
    private String societe;

    @Column(name="fou_adresse")
    private String adresse;

    @Column(name="fou_codepostal")
    private String codePostal;

    @Column(name="fou_ville")
    private String ville;

    @Column(name="fou_pays")
    private String pays;

    @Column(name="fou_telephone")
    private String telephone;

    @Column(name="fou_fax")
    private String fax;

    @Column(name="fou_email")
    private String email;

    @Column(name="fou_telephone2")
    private String telephone2;

    @Column(name="fou_fax2")
    private String fax2;

    @Column(name="fou_email2")
    private String email2;

    @Column(name="fou_email3")
    private String email3;

    @Column(name="fou_email4")
    private String email4;

    @Column(name="fou_datecreation")
    private Date dateCreation;

    @Column(name="fou_observations")
    private String observations;

    @Column(name="fou_numtva")
    private String numTva;

    @Column(name="fou_siret")
    private String siret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getEmail4() {
        return email4;
    }

    public void setEmail4(String email4) {
        this.email4 = email4;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getNumTva() {
        return numTva;
    }

    public void setNumTva(String numTva) {
        this.numTva = numTva;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }
}
