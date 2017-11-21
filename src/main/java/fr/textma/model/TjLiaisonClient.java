package fr.textma.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tj_liaisonclient_lic")
public class TjLiaisonClient {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="lic_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lic_climereid")
    private TeClient clientMere;

    @ManyToOne
    @JoinColumn(name = "lic_clifilsid")
    private TeClient clientFils;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeClient getClientMere() {
        return clientMere;
    }

    public void setClientMere(TeClient clientMere) {
        this.clientMere = clientMere;
    }

    public TeClient getClientFils() {
        return clientFils;
    }

    public void setClientFils(TeClient clientFils) {
        this.clientFils = clientFils;
    }
}
