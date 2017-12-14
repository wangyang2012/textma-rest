package fr.textma.service;


import fr.textma.model.WebixTreeNode;

import java.util.List;

public interface RemiseService {

	List<WebixTreeNode> getRemisesByCilent(Integer clientId);

}
