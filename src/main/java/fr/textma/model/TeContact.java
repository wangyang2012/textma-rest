package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name="te_contact_cot")
public class TeContact {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cot_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cot_cli_id")
    private TeClient client;

    @Column(name="cot_nom")
    private String nom;

    @Column(name="cot_prenom")
    private String prenom;

    @Column(name="cot_telephone")
    private String telephone;

    @Column(name="cot_fax")
    private String fax;

    @Column(name="cot_portable")
    private String portable;

    @Column(name="cot_email")
    private String email;

    @Column(name="cot_civilite")
    private String civilite;

    @Column(name="cot_facturation")
    private Boolean facturation;

    @Column(name="cot_logistique")
    private Boolean logistique;

    @Column(name="cot_commercial")
    private Boolean commercial;

    @ManyToOne
    @JoinColumn(name = "cot_fon_id")
    private TeFonctionContact fonction;

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

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Boolean getFacturation() {
        return facturation;
    }

    public void setFacturation(Boolean facturation) {
        this.facturation = facturation;
    }

    public Boolean getLogistique() {
        return logistique;
    }

    public void setLogistique(Boolean logistique) {
        this.logistique = logistique;
    }

    public Boolean getCommercial() {
        return commercial;
    }

    public void setCommercial(Boolean commercial) {
        this.commercial = commercial;
    }

    public TeFonctionContact getFonction() {
        return fonction;
    }

    public void setFonction(TeFonctionContact fonction) {
        this.fonction = fonction;
    }
}
