package fr.textma.service;

import fr.textma.model.Article;
import fr.textma.model.RemiseBrut;
import fr.textma.model.WebixTreeNode;
import fr.textma.repository.ArticleDao;
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

	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<WebixTreeNode> getRemisesByCilent(Integer clientId) {

		List<RemiseBrut> remisesOfClient = remiseDao.getByClientId(clientId);

		Iterable<Article> allArticles = articleDao.findAll();

		List<WebixTreeNode> results = new ArrayList<>();

		allArticles.forEach(article -> {
			Integer familleId = article.getCollection().getFamille().getId();
			Integer collectionId = article.getCollection().getId();
			Integer gammeId = article.getGamme().getId();
			String hashArticle = familleId + "-" + collectionId + "-" + gammeId;

			WebixTreeNode node = new WebixTreeNode();
			node.setId(hashArticle);
			node.setValue(article.getDesignation());

//			node.setData(article.getCodeArticle());
			results.add(node);
		});

//		List<WebixTreeNode> transports = new ArrayList<>();
//		transports.add(new WebixTreeNode(1, "train", true));
//		transports.add(new WebixTreeNode(2, "bus", false));
//		results.add(new WebixTreeNode(3, "transport", true, transports));
//
//		List<WebixTreeNode> animals = new ArrayList<>();
//		animals.add(new WebixTreeNode(4, "lion", true));
//		animals.add(new WebixTreeNode(5, "tigre", false));
//		animals.add(new WebixTreeNode(6, "elephant", true));
//		results.add(new WebixTreeNode(7, "animal", true, animals));

		return results;
	}
}
