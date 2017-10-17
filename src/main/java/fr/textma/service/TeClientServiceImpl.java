package fr.textma.service;

import fr.textma.model.TeClient;
import fr.textma.repository.TeClientDao;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("teClientService")
@Transactional
public class TeClientServiceImpl implements TeClientService{

	@Autowired
	private TeClientDao dao;

	public TeClient findById(Integer id) {
		return dao.findOne(id);
	}

	public Page<TeClient> findByName(String name, Map<String, String> filter, Pageable pageable) {
	    if (StringUtils.isEmpty(name)) {
//	    	return dao.findAll(pageable);
        } else {
//	        return dao.findByName(name, pageable);
			return null;
        }
	}
}
