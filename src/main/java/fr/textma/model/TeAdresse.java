package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="te_adresse_adr")
public class TeAdresse {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="adr_id")
    private Integer id;

    @Column(name="adr_clifou_id")
    private Integer clientId;

    @Column(name="adr_nomsociete")
    private String nomSociete;

    @Column(name="adr_adresse")
    private String adresse;

    @Column(name="adr_codepostal")
    private String codePostal;

    @Column(name="adr_telephone")
    private String telephone;

    @Column(name="adr_fax")
    private String fax;

    @Column(name="adr_email")
    private String email;

    @Column(name="adr_ville")
    private String ville;

    @Column(name="adr_observations")
    private String observations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
