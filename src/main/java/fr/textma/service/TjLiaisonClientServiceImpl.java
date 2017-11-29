package fr.textma.service;

import fr.textma.model.TeClient;
import fr.textma.model.TjLiaisonClient;
import fr.textma.repository.TjLiaisonClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("tjLiaisonClientService")
@Transactional
public class TjLiaisonClientServiceImpl implements TjLiaisonClientService {

	@Autowired
	private TjLiaisonClientDao dao;

	public TjLiaisonClient findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Page<TjLiaisonClient> findByClientMere(TeClient clientMere, Pageable pageable) {
		return dao.findByClientMere(clientMere, pageable);
	}

	@Override
	public Page<TjLiaisonClient> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Page<TeClient> findAllClientMere(Pageable pageable) {
		return dao.findDistinctClientMere(pageable);
	}

}
