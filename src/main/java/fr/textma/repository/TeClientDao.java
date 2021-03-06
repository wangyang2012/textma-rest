package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TeClientDao extends CrudRepository<TeClient, Integer> {
    TeClient findOneById(Integer id);
    Page<TeClient> findAll(Pageable pageable);
    Page<TeClient> findById(Integer id, Pageable pageable);
    Page<TeClient> findByNomLike(String nom, Pageable pageable);
    Page<TeClient> findByNomLikeOrAdresseLikeOrVilleLike(String nom, String adresse, String ville, Pageable pageable);

    @Modifying
    @Query("update TeClient set observations = :observations where id=:idClient")
    void updateObservations(@Param("idClient") Integer idClient, @Param("observations") String observations);

    /*select * from te_client_cli client left join
    (SELECT fac_cli_id, sum(fac_totalttc) facture_total, count(*) facture_number FROM textma.te_facture_fac where YEAR(fac_datecreation) = YEAR(CURDATE()) group by fac_cli_id) fac
    on client.cli_id = fac.fac_cli_id order by fac.facture_total desc;
    */

    //@Query("select teClient from TeClient t left join fetch collectionSql.subCollections where collectionSql.id =:id")
    //@Query("select teClient from TeClient client left join (SELECT teFacture, sum(totalTtc) totalFacture FROM TeFacture facture where YEAR(facture.dateCreation) = YEAR(CURDATE()) group by facture.clientId) fac on client.id = fac.clientId order by fac.totalTtc desc")
//    @Query("select teClient from TeClient client left join TeFacture teFacture")
//    Page<TeClient> findByNameLike(@Param("name") String name, Pageable pageable);
}
