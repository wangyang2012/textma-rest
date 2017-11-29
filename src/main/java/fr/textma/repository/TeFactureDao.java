package fr.textma.repository;


import fr.textma.model.TeClient;
import fr.textma.model.TeFacture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeFactureDao extends CrudRepository<TeFacture, Integer> {

    Page<TeFacture> findByClient(TeClient client, Pageable pageable);

    @Query("select facture from TeFacture facture where facture.client.id = :clientId and YEAR(facture.dateCreation) = YEAR(CURDATE())")
    Page<TeFacture> findCurrentYearFacturesByClientId(@Param("clientId") Integer clientId, Pageable pageable);
}

