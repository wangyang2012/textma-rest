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

	public Page<TeClient> getClientWithFilters(Map<String, String> filter, Pageable pageable) {
		String name = filter.get("filter[name]");
		String strId = filter.get("filter[id]");
		Integer id = null;
		if (!StringUtils.isEmpty(strId)) {
			id = Integer.valueOf(strId);
		}

		if (id != null) {
			return dao.findById(id, pageable);
		} else if (!StringUtils.isEmpty(name)) {
			return dao.findByNameLike("%"+name+"%", pageable);
		} else if (StringUtils.isEmpty(name) && id == null) {
	    	return dao.findAll(pageable);
        }
        return null;
	}

	@Override
	public void update(TeClient client) {
		dao.save(client);
	}
}
