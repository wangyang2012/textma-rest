package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeClientDao extends JpaRepository<TeClient, Integer> {

    TeClient findById(int id);

    List<TeClient> findByName(String name);
}

