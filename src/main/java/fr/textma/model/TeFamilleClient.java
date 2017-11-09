package fr.textma.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="te_clifamille_clf")
public class TeFamilleClient {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="clf_id")
    private Integer id;

    @Column(name="clf_nom")
    private String nom;

    @OneToMany(mappedBy = "famille", cascade = CascadeType.ALL)
    private List<TeClient> clients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<TeClient> getClients() {
        return clients;
    }

    public void setClients(List<TeClient> clients) {
        this.clients = clients;
    }
}
