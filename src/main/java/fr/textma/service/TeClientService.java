package fr.textma.service;


import fr.textma.model.TeClient;

import java.util.List;


public interface TeClientService {


	TeClient findById(int id);

	List<TeClient> findByName(String name);

}
