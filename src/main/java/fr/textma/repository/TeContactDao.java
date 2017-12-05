package fr.textma.repository;


import fr.textma.model.TeContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TeContactDao extends CrudRepository<TeContact, Integer> {

    Page<TeContact> findAll(Pageable pageable);

    @Query("SELECT tc FROM TeContact tc WHERE tc.client.nom like :search or tc.nom like :search or tc.prenom like :search or tc.telephone like :search or tc.portable like :search or tc.email like :search")
    Page<TeContact> search(@Param("search") String search, Pageable pageable);

    @Query("SELECT tc FROM TeContact tc WHERE tc.client.id = :clientId")
    Page<TeContact> findByClientId(@Param("clientId") Integer clientId, Pageable pageable);
}
