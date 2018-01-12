package fr.textma.service;


import fr.textma.model.Remise;
import fr.textma.model.WebixTreeNode;

import java.util.List;

public interface RemiseService {

	List<WebixTreeNode> getRemisesByCilent(Integer clientId, String nodeId);

	Remise getRemise(Integer clientId, String nodeId);

}
