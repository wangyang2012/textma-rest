package fr.textma.service;

import fr.textma.model.*;
import fr.textma.repository.ArticleDao;
import fr.textma.repository.FamilleArticleDao;
import fr.textma.repository.GammeArticleDao;
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
	private FamilleArticleDao familleArticleDao;

	@Autowired
	private GammeArticleDao gammeArticleDao;

	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<WebixTreeNode> getRemisesByCilent(Integer clientId) {

		List<RemiseBrut> remisesOfClient = remiseDao.getByClientId(clientId);

		Iterable<FamilleArticle> familleArticles = familleArticleDao.findAll();

		Iterable<GammeArticle> gammeArticles = gammeArticleDao.findAll();

		List<WebixTreeNode> results = new ArrayList<>();

		if (familleArticles != null) {
			// Familles des articles
			familleArticles.forEach(famille -> {
				WebixTreeNode nodeFamille = new WebixTreeNode(famille.getId().toString(), famille.getLibelle());
//				if (famille.getCollections() != null && !famille.getCollections().isEmpty()) {
//					// Collections des articles
//					List<WebixTreeNode> collections = new ArrayList<>();
//					for (CollectionArticle collection : famille.getCollections()) {
//						WebixTreeNode nodeCollection = new WebixTreeNode(famille.getId() + "-" + collection.getId(), collection.getDesignation());
//						if (gammeArticles != null) {
//							// Gammes des articles
//							List<WebixTreeNode> gammes = new ArrayList<>();
//							gammeArticles.forEach(gamme -> {
//								WebixTreeNode gammeNode = new WebixTreeNode(famille.getId() + "-" + collection.getId() + "-" + gamme.getId(), gamme.getDesignation());
//								// Articles of famille-collection-gamme
////								List<Article> articlesOfGamme = articleDao.findByCollectionAndGamme(collection, gamme);
////								if (articlesOfGamme != null) {
////									List<WebixTreeNode> articles = new ArrayList<>();
////									for (Article article : articlesOfGamme) {
////										WebixTreeNode articleNode = new WebixTreeNode(famille.getId() + "-" + collection.getId() + "-" + gamme.getId() + "-" + article.getId(), article.getDesignation());
////									}
////									gammeNode.setData(articles);
////								}
//								gammes.add(gammeNode);
//							});
//							nodeCollection.setData(gammes);
//						}
//						collections.add(nodeCollection);
//					}
//					nodeFamille.setData(collections);
//				}
				results.add(nodeFamille);
			});
		}

		return results;
	}
}
