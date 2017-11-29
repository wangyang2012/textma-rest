package fr.textma.repository;


import fr.textma.model.TeContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface TeContactDao extends CrudRepository<TeContact, Integer> {
    Page<TeContact> findByClientId(Integer clientId, Pageable pageable);
}
