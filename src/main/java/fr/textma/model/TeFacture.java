package fr.textma.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="te_facture_fac")
public class TeFacture {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fac_id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "fac_cli_id")
    private TeClient client;

    @Column(name="fac_numfacture")
    private String numeroFacture;

    @Column(name="fac_reference")
    private String reference;

    @Column(name="fac_adresse")
    private String adresse;

    @Column(name="fac_raisonsociale")
    private String raisonSociale;

    @Column(name="fac_datecreation")
    private Date dateCreation;

    @Column(name="fac_totalht")
    private BigDecimal totalHt;

    @Column(name="fac_totaltva")
    private BigDecimal totalTva;

    @Column(name="fac_totalttc")
    private BigDecimal totalTtc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(BigDecimal totalHt) {
        this.totalHt = totalHt;
    }

    public BigDecimal getTotalTva() {
        return totalTva;
    }

    public void setTotalTva(BigDecimal totalTva) {
        this.totalTva = totalTva;
    }

    public BigDecimal getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(BigDecimal totalTtc) {
        this.totalTtc = totalTtc;
    }

    public TeClient getClient() {
        return client;
    }

    public void setClient(TeClient client) {
        this.client = client;
    }
}
