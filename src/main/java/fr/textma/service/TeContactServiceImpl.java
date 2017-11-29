package fr.textma.service;

import fr.textma.model.TeContact;
import fr.textma.repository.TeContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("teContactService")
@Transactional
public class TeContactServiceImpl implements TeContactService{

	@Autowired
	private TeContactDao dao;

	@Override
	public Page<TeContact> findByClientId(Integer clientId, Pageable pageable) {
		return dao.findByClientId(clientId, pageable);
	}
}
