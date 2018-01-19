package fr.textma.service;


import fr.textma.model.TeFamilleClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeFamilleClientService {


	Page<TeFamilleClient> findByNomLike(String nom, Pageable pageable);

    void save(TeFamilleClient familleClient);

    void delete(Integer id);

    TeFamilleClient findById(Integer id);
}
