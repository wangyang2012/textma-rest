package fr.textma.service;


import fr.textma.model.TeClient;
import fr.textma.model.TjLiaisonClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TjLiaisonClientService {


	TjLiaisonClient findById(Integer id);

	Page<TeClient> findByClientMere(Integer mereId, Pageable pageable);

	Page<TjLiaisonClient> findAll(Pageable pageable);

	Page<TeClient> findAllClientMere(String search, Pageable pageable);

}
