package fr.textma.repository;


import fr.textma.model.TeFamilleClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TeFamilleClientDao extends CrudRepository<TeFamilleClient, Integer> {

    Page<TeFamilleClient> findByNomLike(String nom, Pageable pageable);
}

