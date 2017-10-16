package fr.textma.service;

import fr.textma.model.TeFacture;
import fr.textma.repository.TeFactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("teFactureService")
@Transactional
public class TeFactureServiceImpl implements TeFactureService{

	@Autowired
	private TeFactureDao dao;

	@Override
	public Page<TeFacture> findByClientId(Integer clientId, Pageable pageable) {
		return dao.findByClientId(clientId, pageable);
	}
}
