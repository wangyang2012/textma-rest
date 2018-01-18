package fr.textma.model;

import javax.persistence.*;

@Entity
@Table(name = "tj_liaisonclient_lic")
public class LiaisonClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lic_id")
    private Integer id;

    @Column(name = "lic_climereid")
    private Integer mereId;

    @Column(name = "lic_clifilsid")
    private Integer filsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMereId() {
        return mereId;
    }

    public void setMereId(Integer mereId) {
        this.mereId = mereId;
    }

    public Integer getFilsId() {
        return filsId;
    }

    public void setFilsId(Integer filsId) {
        this.filsId = filsId;
    }
}
