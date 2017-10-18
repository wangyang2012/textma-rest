package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TeClientDao extends CrudRepository<TeClient, Integer> {
    Page<TeClient> findAll(Pageable pageable);
    Page<TeClient> findById(Integer id, Pageable pageable);
    Page<TeClient> findByNameLike(String name, Pageable pageable);

}
