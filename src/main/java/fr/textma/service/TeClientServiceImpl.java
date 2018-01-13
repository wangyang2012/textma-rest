package fr.textma.service;

import fr.textma.model.TeClient;
import fr.textma.repository.ModePaiementDao;
import fr.textma.repository.RepresentantDao;
import fr.textma.repository.TeClientDao;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("teClientService")
@Transactional
public class TeClientServiceImpl implements TeClientService{

	@Autowired
	private TeClientDao dao;

	@Autowired
	private ModePaiementDao modePaiementDao;

	@Autowired
	private RepresentantDao representantDao;


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
	public void save(TeClient client) {
		dao.save(client);
	}

	@Override
	public void deleteClientById(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<TeClient> getSousClients(Integer id) {
		TeClient client = findById(id);
		return client.getSousClients();
	}
}
