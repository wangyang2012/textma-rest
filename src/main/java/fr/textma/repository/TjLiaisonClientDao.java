package fr.textma.repository;


import fr.textma.model.TeClient;
import fr.textma.model.TjLiaisonClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TjLiaisonClientDao extends CrudRepository<TjLiaisonClient, Integer> {
    TjLiaisonClient findOneById(Integer id);
    Page<TjLiaisonClient> findAll(Pageable pageable);
    Page<TjLiaisonClient> findByClientMere(TeClient clientMere, Pageable pageable);
    @Query("select teClient from TeClient teClient where teClient.id in (select distinct clientMere.id from TjLiaisonClient)")
    Page<TeClient> findDistinctClientMere(Pageable pageable);
}
