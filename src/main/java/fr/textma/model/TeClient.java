package fr.textma.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="te_client_cli")
public class TeClient {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cli_id")
    private Integer id;

    @Column(name="cli_bloque")
    private Boolean bloque;

    @Column(name="cli_ferme")
    private Boolean ferme;

    @Column(name="cli_datemodification")
    private Date derniereModification;

    @Column(name="cli_codeclient")
    private Integer codeClient;

    @Column(name="cli_societe")
    private String nom;

    @Column(name="cli_adresse")
    private String addresse;

    @Column(name="cli_codepostal")
    private String codePostal;

    @Column(name="cli_ville")
    private String ville;

    @Column(name="cli_telephone")
    private String telephone;

    @Column(name="cli_siret")
    private String siret;

    @Column(name="cli_email3")
    private String rcs;

    @ManyToOne
    @JoinColumn(name = "cli_clf_id")
    private TeFamilleClient famille;

    @ManyToOne
    @JoinColumn(name = "cli_mpa_id")
    private TsModePaiement modePaiement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getBloque() {
        return bloque;
    }

    public void setBloque(Boolean bloque) {
        this.bloque = bloque;
    }

    public Boolean getFerme() {
        return ferme;
    }

    public void setFerme(Boolean ferme) {
        this.ferme = ferme;
    }

    public Date getDerniereModification() {
        return derniereModification;
    }

    public void setDerniereModification(Date derniereModification) {
        this.derniereModification = derniereModification;
    }

    public Integer getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Integer codeClient) {
        this.codeClient = codeClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRcs() {
        return rcs;
    }

    public void setRcs(String rcs) {
        this.rcs = rcs;
    }

    public TeFamilleClient getFamille() {
        return famille;
    }

    public void setFamille(TeFamilleClient famille) {
        this.famille = famille;
    }

    public TsModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(TsModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }
}
