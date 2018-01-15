package fr.textma.service;

import fr.textma.model.CommercialInterne;
import fr.textma.repository.CommercialInterneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("CommercialInterneService")
@Transactional
public class CommercialInterneServiceImpl implements CommercialInterneService {

	@Autowired
	private CommercialInterneDao dao;


	@Override
	public Iterable<CommercialInterne> findAll() {
		return dao.findAll();
	}
}
