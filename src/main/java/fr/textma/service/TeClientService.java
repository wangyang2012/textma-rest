package fr.textma.service;


import fr.textma.model.TeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;


public interface TeClientService {


	TeClient findById(Integer id);

	Page<TeClient> getClientWithFilters(Map<String, String> filter, Pageable pageable);

	void update(TeClient client);

}
