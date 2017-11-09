package fr.textma.service;


import fr.textma.model.TeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;


public interface TeClientService {


	TeClient findById(Integer id);

	Page<TeClient> searchClients(String search, Pageable pageable);

	void update(TeClient client);

}
