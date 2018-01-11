package fr.textma.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "te_client_cli")
public class TeClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Integer id;

    @Column(name = "cli_bloque")
    private Boolean bloque;

    @Column(name = "cli_ferme")
    private Boolean ferme;

    @Column(name = "cli_ce")
    private Boolean virement;

    @Column(name = "cli_affacturage")
    private Boolean surveillanceSocieteCom;

    @Column(name = "cli_mauvaispayeur")
    private Boolean mauvaisPayeur;

    @Column(name = "cli_datemodification")
    private Date derniereModification;

    @Column(name = "cli_codeclient")
    private Integer codeClient;

    @Column(name = "cli_societe")
    private String nom;

    @Column(name = "cli_adresse")
    private String adresse;

    @Column(name = "cli_codepostal")
    private String codePostal;

    @Column(name = "cli_ville")
    private String ville;

    @Column(name = "cli_pays")
    private String pays;

    @Column(name = "cli_telephone")
    private String telephone;

    @Column(name = "cli_fax")
    private String fax;

    @Column(name = "cli_email")
    private String email;

    @Column(name = "cli_url")
    private String url;

    @Column(name = "cli_siret")
    private String siret;

    @Column(name = "cli_email3")
    private String rcs;

    @Column(name = "cli_email4")
    private String ouvertureCompte;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "cli_fju_id")
    private FormeJuridique formeJuridique;

    @Column(name = "cli_observations")
    private String observations;

    @Column(name = "cli_numtva")
    private String numeroTva;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "cli_clf_id")
    private TeFamilleClient famille;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "cli_rep_id")
    private Representant representant;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "cli_mpa_id")
    private TsModePaiement modePaiement;

    @Column(name = "cli_escompte")
    private BigDecimal escompte;

    @Column(name = "cli_soldedu")
    private BigDecimal soldeDu;

    @OneToMany(mappedBy = "client")
    private List<TeFacture> factures;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tj_liaisonclient_lic",
            joinColumns = @JoinColumn(name = "lic_climereid"),
            inverseJoinColumns = @JoinColumn(name = "lic_clifilsid")
    )
    private List<TeClient> sousClients;

    @Formula("(select COALESCE(sum(fac.fac_totalttc), 0) from te_facture_fac fac where fac.fac_cli_id=cli_id and YEAR(fac.fac_datecreation) = YEAR(CURDATE()))")
    private BigDecimal totalFacture;


    public String getCodepostal() {
        return codePostal;
    }

    public void setCodepostal(String codepostal) {
        this.codePostal = codepostal;
    }

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

    public Date getDernieremodification() {
        return derniereModification;
    }

    public void setDerniereModification(Date derniereModification) {
        this.derniereModification = derniereModification;
    }

    public void setDernieremodification(Date derniereModification) {
        this.derniereModification = derniereModification;
    }

    public Integer getCodeClient() {
        return codeClient;
    }

    public Integer getCodeclient() {
        return codeClient;
    }

    public void setCodeClient(Integer codeClient) {
        this.codeClient = codeClient;
    }

    public void setCodeclient(Integer codeClient) {
        this.codeClient = codeClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public FormeJuridique getFormeJuridique() {
        return formeJuridique;
    }

    public void setFormeJuridique(FormeJuridique formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    public TsModePaiement getModePaiement() {
        return modePaiement;
    }

    public TsModePaiement getModepaiement() {
        return modePaiement;
    }

    public void setModePaiement(TsModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setModepaiement(TsModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public List<TeFacture> getFactures() {
        return factures;
    }

    public void setFactures(List<TeFacture> factures) {
        this.factures = factures;
    }

    public BigDecimal getTotalFacture() {
        return totalFacture;
    }

    public BigDecimal getTotalfacture() {
        return totalFacture;
    }

    public void setTotalFacture(BigDecimal totalFacture) {
        this.totalFacture = totalFacture;
    }

    public void setTotalfacture(BigDecimal totalFacture) {
        this.totalFacture = totalFacture;
    }

    public List<TeClient> getSousClients() {
        return sousClients;
    }

    public void setSousClients(List<TeClient> sousClients) {
        this.sousClients = sousClients;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getNumeroTva() {
        return numeroTva;
    }

    public void setNumeroTva(String numeroTva) {
        this.numeroTva = numeroTva;
    }

    public String getOuvertureCompte() {
        return ouvertureCompte;
    }

    public void setOuvertureCompte(String ouvertureCompte) {
        this.ouvertureCompte = ouvertureCompte;
    }

    public Representant getRepresentant() {
        return representant;
    }

    public void setRepresentant(Representant representant) {
        this.representant = representant;
    }

    public BigDecimal getEscompte() {
        return escompte;
    }

    public void setEscompte(BigDecimal escompte) {
        this.escompte = escompte;
    }

    public BigDecimal getSoldeDu() {
        return soldeDu;
    }

    public void setSoldeDu(BigDecimal soldeDu) {
        this.soldeDu = soldeDu;
    }

    public Boolean getVirement() {
        return virement;
    }

    public void setVirement(Boolean virement) {
        this.virement = virement;
    }

    public Boolean getSurveillanceSocieteCom() {
        return surveillanceSocieteCom;
    }

    public void setSurveillanceSocieteCom(Boolean surveillanceSocieteCom) {
        this.surveillanceSocieteCom = surveillanceSocieteCom;
    }

    public void setSurveillancesocietecom(Boolean surveillanceSocieteCom) {
        this.surveillanceSocieteCom = surveillanceSocieteCom;
    }

    public Boolean getSurveillancesocietecom() {
        return surveillanceSocieteCom;
    }

    public Boolean getMauvaisPayeur() {
        return mauvaisPayeur;
    }

    public void setMauvaisPayeur(Boolean mauvaisPayeur) {
        this.mauvaisPayeur = mauvaisPayeur;
    }

    public Boolean getMauvaispayeur() {
        return mauvaisPayeur;
    }

    public void setMauvaispayeur(Boolean mauvaisPayeur) {
        this.mauvaisPayeur = mauvaisPayeur;
    }
}
