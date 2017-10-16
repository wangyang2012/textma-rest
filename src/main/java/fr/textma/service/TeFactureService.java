package fr.textma.service;


import fr.textma.model.TeFacture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeFactureService {

	Page<TeFacture> findByClientId(Integer clientId, Pageable pageable);

}
