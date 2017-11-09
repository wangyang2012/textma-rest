package fr.textma.repository;


import fr.textma.model.TeClient;
import fr.textma.model.TeFacture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TeFactureDao extends CrudRepository<TeFacture, Integer> {

    Page<TeFacture> findByClient(TeClient client, Pageable pageable);
}

