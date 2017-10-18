package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface TeClientDao extends CrudRepository<TeClient, Integer> {
    Page<TeClient> findAll(Pageable pageable);
}
