package fr.textma.service;

import fr.textma.model.TeContact;
import fr.textma.model.TeFonctionContact;
import fr.textma.repository.TeContactDao;
import fr.textma.repository.TeFonctionContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("teFonctionContactService")
@Transactional
public class TeFonctionContactServiceImpl implements TeFonctionContactService{

	@Autowired
	private TeFonctionContactDao dao;

	@Override
	public Iterable<TeFonctionContact> findAll() {
		return dao.findAll();
	}
}
