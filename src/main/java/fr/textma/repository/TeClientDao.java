package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TeClientDao extends CrudRepository<TeClient, Integer> {
}
