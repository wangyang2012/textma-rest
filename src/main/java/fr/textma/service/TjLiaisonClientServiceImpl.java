package fr.textma.service;

import fr.textma.model.TeClient;
import fr.textma.model.TjLiaisonClient;
import fr.textma.repository.TjLiaisonClientDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("tjLiaisonClientService")
@Transactional
public class TjLiaisonClientServiceImpl implements TjLiaisonClientService {

	@Autowired
	private TjLiaisonClientDao dao;

	public TjLiaisonClient findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Page<TeClient> findByClientMere(Integer mereId, Pageable pageable) {
		return dao.findByClientMere(mereId, pageable);
	}

	@Override
	public Page<TjLiaisonClient> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Page<TeClient> findAllClientMere(String search, Pageable pageable) {
		if (StringUtils.isEmpty(search)) {
			return dao.findAllClientMere(pageable);
		} else {
			return dao.findAllClientMereWithSearch(search, pageable);
		}
	}

}
