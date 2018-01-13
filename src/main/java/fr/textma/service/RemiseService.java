package fr.textma.service;


import fr.textma.model.RemiseBrut;
import fr.textma.model.WebixTreeNode;

import java.util.List;

public interface RemiseService {

	List<WebixTreeNode> getRemisesByCilent(Integer clientId, String nodeId);

	RemiseBrut getRemiseBrut(Integer clientId, String nodeId);

}
