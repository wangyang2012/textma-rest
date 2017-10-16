package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeClientDao extends JpaRepository<TeClient, Integer> {
}

