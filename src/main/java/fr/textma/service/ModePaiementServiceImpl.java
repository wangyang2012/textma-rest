package fr.textma.service;

import fr.textma.model.TsModePaiement;
import fr.textma.repository.ModePaiementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("modePaiementService")
@Transactional
public class ModePaiementServiceImpl implements ModePaiementService {

	@Autowired
	private ModePaiementDao dao;


	@Override
	public Iterable<TsModePaiement> findAll() {
		return dao.findAll();
	}
}
