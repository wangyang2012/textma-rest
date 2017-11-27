package fr.textma.service;

import fr.textma.model.TeFacture;
import fr.textma.model.TeFamilleClient;
import fr.textma.repository.TeClientDao;
import fr.textma.repository.TeFactureDao;
import fr.textma.repository.TeFamilleClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("teFamilleClientService")
@Transactional
public class TeFamilleClientServiceImpl implements TeFamilleClientService{

	@Autowired
	private TeFamilleClientDao dao;


	@Override
	public Page<TeFamilleClient> findByNomLike(String nom, Pageable pageable) {
		return dao.findByNomLike("%"+nom+"%", pageable);
	}
}
