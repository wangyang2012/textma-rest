package fr.textma.service;

import fr.textma.model.LiaisonClient;
import fr.textma.repository.LiaisonClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("liaisonClientService")
@Transactional
public class LiaisonClientServiceImpl implements LiaisonClientService {

	@Autowired
	private LiaisonClientDao dao;

	@Override
	public void save(LiaisonClient liaison) {
		dao.save(liaison);
	}

	@Override
	public void delete(Integer idMere, Integer idFils) {
		dao.deleteByMereIdAndFilsId(idMere, idFils);
	}
}
