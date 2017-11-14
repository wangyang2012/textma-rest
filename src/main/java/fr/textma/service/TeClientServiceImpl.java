package fr.textma.service;

import fr.textma.model.TeClient;
import fr.textma.repository.TeClientDao;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("teClientService")
@Transactional
public class TeClientServiceImpl implements TeClientService{

	@Autowired
	private TeClientDao dao;

	public TeClient findById(Integer id) {
		return dao.findOne(id);
	}

	public Page<TeClient> searchClients(String search, Pageable pageable) {
		if (StringUtils.isEmpty(search)) {
			return dao.findAll(pageable);
		}

		return dao.findByNomLikeOrAdresseLikeOrVilleLike("%"+search+"%", "%"+search+"%", "%"+search+"%", pageable);
	}

	@Override
	public void update(TeClient client) {
		dao.save(client);
	}
}
