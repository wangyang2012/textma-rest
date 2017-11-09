package fr.textma.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="te_client_cli")
public class TeClient {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cli_id")
    private Integer id;

    @Column(name="cli_societe")
    private String name;

    @Column(name="cli_siret")
    private String siret;

    @Column(name="cli_adresse")
    private String address;

    @Column(name="cli_codepostal")
    private String codePostal;

    @Column(name="cli_ville")
    private String ville;

    @OneToMany(mappedBy = "client")
    private List<TeFacture> factures;

//    private BigDecimal totalFacture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

//    public BigDecimal getTotalFacture() {
//        return totalFacture;
//    }
//
//    public void setTotalFacture(BigDecimal totalFacture) {
//        this.totalFacture = totalFacture;
//    }

    public List<TeFacture> getFactures() {
        return factures;
    }

    public void setFactures(List<TeFacture> factures) {
        this.factures = factures;
    }
}
