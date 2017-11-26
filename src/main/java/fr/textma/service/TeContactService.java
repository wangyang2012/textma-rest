package fr.textma.service;


import fr.textma.model.TeContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeContactService {


	Page<TeContact> findByClientId(Integer clientId, Pageable pageable);

}
