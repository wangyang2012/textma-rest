package fr.textma.service;


import fr.textma.model.TeContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeContactService {

	Page<TeContact> findAll(Pageable pageable);

	Page<TeContact> search(String search, Pageable pageable);

	Page<TeContact> findByClientId(Integer clientId, Pageable pageable);

    TeContact findById(Integer id);

    void save(TeContact contact);

    void delete(Integer id);
}
