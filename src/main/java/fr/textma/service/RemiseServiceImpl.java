package fr.textma.service;

import fr.textma.model.RemiseBrut;
import fr.textma.model.WebixTreeNode;
import fr.textma.repository.RemiseBrutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("RemiseService")
@Transactional
public class RemiseServiceImpl implements RemiseService {

	@Autowired
	private RemiseBrutDao remiseDao;

	@Override
	public List<WebixTreeNode> getRemisesByCilent(Integer clientId) {

		List<RemiseBrut> remisesOfClient = remiseDao.getByClientId(clientId);

		List<WebixTreeNode> results = new ArrayList<>();

		List<WebixTreeNode> transports = new ArrayList<>();
		transports.add(new WebixTreeNode(1, "train", true));
		transports.add(new WebixTreeNode(2, "bus", false));
		results.add(new WebixTreeNode(3, "transport", true, transports));

		List<WebixTreeNode> animals = new ArrayList<>();
		animals.add(new WebixTreeNode(4, "lion", true));
		animals.add(new WebixTreeNode(5, "tigre", false));
		animals.add(new WebixTreeNode(6, "elephant", true));
		results.add(new WebixTreeNode(7, "animal", true, animals));

		return results;
	}
}
