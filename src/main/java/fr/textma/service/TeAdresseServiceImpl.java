package fr.textma.service;

import fr.textma.model.TeAdresse;
import fr.textma.repository.TeAdresseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("TeAdresseService")
@Transactional
public class TeAdresseServiceImpl implements TeAdresseService{

	@Autowired
	private TeAdresseDao dao;

	@Override
	public Page<TeAdresse> findByClientId(Integer clientId, Pageable pageable) {
		return dao.findByClientId(clientId, pageable);
	}

	@Override
	public TeAdresse save(TeAdresse adresse) {
		return dao.save(adresse);
	}
}
