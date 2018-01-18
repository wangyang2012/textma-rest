package fr.textma.service;


import fr.textma.model.TeAdresse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeAdresseService {


	Page<TeAdresse> findByClientId(Integer clientId, Pageable pageable);

	TeAdresse save(TeAdresse adresse);

	void delete(Integer id);

	TeAdresse getAdresse(Integer id);

}
