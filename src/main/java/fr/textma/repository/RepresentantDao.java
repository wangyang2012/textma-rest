package fr.textma.repository;


import fr.textma.model.Representant;
import org.springframework.data.repository.CrudRepository;


public interface RepresentantDao extends CrudRepository<Representant, Integer> {
}
