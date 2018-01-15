package fr.textma.repository;


import fr.textma.model.TeFonctionContact;
import org.springframework.data.repository.CrudRepository;


public interface TeFonctionContactDao extends CrudRepository<TeFonctionContact, Integer> {

    Iterable<TeFonctionContact> findAll();
}
