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
import java.util.HashMap;
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
    public List<WebixTreeNode> getRemisesByCilent(Integer clientId, String nodeId) {

        // SELECT art_acl_id, art_aga_id, count(*) FROM textma.te_article_art group by art_acl_id, art_aga_id;

        List<RemiseBrut> remisesOfClient = remiseDao.getByClientId(clientId);

        HashMap<String, RemiseBrut> mapRemisesOfClient = new HashMap<>();
        for (RemiseBrut remise : remisesOfClient) {
            String key = remise.getFamilleArticleId() + "-" + remise.getCollectionArticleId() + "-" + remise.getGammeArticleId() + "-" + remise.getArticleId();
            mapRemisesOfClient.put(key, remise);
        }

        Iterable<FamilleArticle> familleArticles = familleArticleDao.findAll();

        Iterable<GammeArticle> gammeArticles = gammeArticleDao.findAll();

        List<WebixTreeNode> results = new ArrayList<>();

        String[] nodeIds = null;
        if (nodeId != null) {
            nodeIds = nodeId.split("-");
        }
        // level 0 => racine; load only familles
        // level 1 => famille clicked; load collections
        // level 2 => collection clicked; load gammes
        // level 3 => gamme clicked; load articles;
        final Integer level = nodeIds == null ? 0 : nodeIds.length;

        // level 0 => racine; load only familles
        if (level >= 0 && familleArticles != null) {
            // Familles des articles
            String[] finalNodeIds = nodeIds;
            familleArticles.forEach(famille -> {
                Integer nbCollections = famille.getCollections() == null ? 0 : famille.getCollections().size();
                WebixTreeNode nodeFamille = new WebixTreeNode(famille.getId().toString(), famille.getLibelle() + " (" + nbCollections + ")", false);

                if (mapRemisesOfClient.get(famille.getId()+"-0-0-0") != null) {
                    nodeFamille.setValue("<span class='remised'>"+famille.getLibelle() + " (" + nbCollections + ")" + "</span>");
                }

                // level 1 => famille clicked; load collections
                if (level >= 1 && famille.getCollections() != null && !famille.getCollections().isEmpty()) {
                    Integer clickedFamilleId = Integer.valueOf(finalNodeIds[0]);
                    if (famille.getId().equals(clickedFamilleId)) {
                        // Collections des articles
                        List<WebixTreeNode> collections = new ArrayList<>();
                        for (CollectionArticle collection : famille.getCollections()) {
                            WebixTreeNode nodeCollection = new WebixTreeNode(famille.getId() + "-" + collection.getId(), collection.getDesignation());

                            if (mapRemisesOfClient.get("0-"+collection.getId()+"-0-0") != null) {
                                nodeCollection.setValue("<span class='remised'>" + collection.getDesignation() + "</span>");
                            }

                            // level 2 => collection clicked; load gammes
                            if (level >= 2 && gammeArticles != null) {
                                Integer clickedCollection = Integer.valueOf(finalNodeIds[1]);
                                if (!collection.getId().equals(clickedCollection)) {
                                    continue;
                                }

                                // Gammes des articles
                                List<WebixTreeNode> gammes = new ArrayList<>();
                                gammeArticles.forEach(gamme -> {

                                    // Articles of famille-collection-gamme
                                    // level 3 => gamme clicked; load articles;
                                    List<Article> articlesOfGamme = articleDao.findByCollectionAndGamme(collection, gamme);
                                    if (articlesOfGamme != null && articlesOfGamme.size() > 0) {
                                        WebixTreeNode gammeNode = new WebixTreeNode(famille.getId() + "-" + collection.getId() + "-" + gamme.getId(), gamme.getDesignation() + " (" + articlesOfGamme.size() + ")");
                                        List<WebixTreeNode> articles = new ArrayList<>();
                                        if (level >= 3) {
                                            Integer clickedGamme = Integer.valueOf(finalNodeIds[2]);
                                            if (gamme.getId().equals(clickedGamme)) {
                                                for (Article article : articlesOfGamme) {
                                                    WebixTreeNode articleNode = new WebixTreeNode(famille.getId() + "-" + collection.getId() + "-" + gamme.getId() + "-" + article.getId(), article.getDesignation());
                                                    articles.add(articleNode);
                                                }
                                                gammeNode.setOpen(true);
                                                gammeNode.setData(articles);
                                            }
                                        }
                                        gammes.add(gammeNode);
                                    }

                                });
                                nodeCollection.setOpen(true);
                                nodeCollection.setData(gammes);
                            }
                            collections.add(nodeCollection);
                        }
                        nodeFamille.setOpen(true);
                        nodeFamille.setData(collections);
                    }
                }
                results.add(nodeFamille);
            });
        }

        return results;
    }
}
