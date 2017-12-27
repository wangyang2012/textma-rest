package fr.textma.service;

import fr.textma.model.Representant;
import fr.textma.model.TsModePaiement;
import fr.textma.repository.ModePaiementDao;
import fr.textma.repository.RepresentantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("representantService")
@Transactional
public class RepresentantServiceImpl implements RepresentantService {

	@Autowired
	private RepresentantDao dao;


	@Override
	public Iterable<Representant> findAll() {
		return dao.findAll();
	}
}
