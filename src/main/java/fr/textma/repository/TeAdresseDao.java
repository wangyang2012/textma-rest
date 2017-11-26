package fr.textma.repository;


import fr.textma.model.TeAdresse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface TeAdresseDao extends CrudRepository<TeAdresse, Integer> {
    Page<TeAdresse> findByClientId(Integer clientId, Pageable pageable);
}
