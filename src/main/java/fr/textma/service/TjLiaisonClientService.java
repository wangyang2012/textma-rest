package fr.textma.service;


import fr.textma.model.TeClient;
import fr.textma.model.TjLiaisonClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TjLiaisonClientService {


	TjLiaisonClient findById(Integer id);

	Page<TjLiaisonClient> findByClientMere(TeClient clientMere, Pageable pageable);

	Page<TjLiaisonClient> findAll(Pageable pageable);

}
