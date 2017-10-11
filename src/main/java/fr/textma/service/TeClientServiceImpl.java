package fr.textma.service;

import fr.textma.model.TeClient;
import fr.textma.repository.TeClientDao;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("teClientService")
@Transactional
public class TeClientServiceImpl implements TeClientService{

	@Autowired
	private TeClientDao dao;


	public TeClient findById(int id) {
		return dao.findById(id);
	}

	public List<TeClient> findByName(String name) {
	    if (StringUtils.isEmpty(name)) {
	        return dao.findAll();
        } else {
	        return dao.findByName(name);
        }
	}
}
