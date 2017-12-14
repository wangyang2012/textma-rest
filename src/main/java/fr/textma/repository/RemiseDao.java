package fr.textma.repository;


import fr.textma.model.Remise;
import fr.textma.model.TeClient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RemiseDao extends CrudRepository<Remise, Integer> {
    List<Remise> getByClient(TeClient cilent);
}
