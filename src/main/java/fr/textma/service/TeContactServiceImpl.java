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
	public Page<TeContact> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Page<TeContact> search(String search, Pageable pageable) {
		return dao.search("%"+search+"%", pageable);
	}

	@Override
	public Page<TeContact> findByClientId(Integer clientId, Pageable pageable) {
		return dao.findByClientId(clientId, pageable);
	}

	@Override
	public TeContact findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public void save(TeContact contact) {
		dao.save(contact);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}
}
