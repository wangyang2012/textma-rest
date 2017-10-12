package fr.textma.service;


import fr.textma.model.TeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeClientService {


	TeClient findById(Integer id);

	Page<TeClient> findByName(String name, Pageable pageable);

}
