package fr.textma.service;

import fr.textma.model.*;
import fr.textma.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Autowired
    private RemiseCombinaisonDao remiseCombinaisonDao;

    @Override
    public List<WebixTreeNode> getRemisesByCilent(Integer clientId, String nodeId) {

        // SELECT art_acl_id, art_aga_id, count(*) FROM textma.te_article_art group by art_acl_id, art_aga_id;
        // SELECT fam.afa_id famille_id, fam.afa_libelle famille_libelle, art.art_acl_id collection_id, col.acl_designation collection_libelle, art.art_aga_id gamme_id, gam.aga_designation gamme_libelle, count(*) count FROM textma.te_article_art art join te_artcollection_acl col on art.art_acl_id=col.acl_id join te_artfamille_afa fam on fam.afa_id = col.acl_afa_id join te_artgamme_aga gam on art.art_aga_id = gam.aga_id group by art_acl_id, art_aga_id order by famille_id, collection_id, gamme_id;
        // SELECT fam.afa_id famille_id, fam.afa_libelle famille_libelle, art.art_acl_id collection_id, col.acl_designation collection_libelle, art.art_aga_id gamme_id, gam.aga_designation gamme_libelle, art.art_id articleId, art.art_designation articleLibelle FROM textma.te_article_art art join te_artcollection_acl col on art.art_acl_id=col.acl_id join te_artfamille_afa fam on fam.afa_id = col.acl_afa_id join te_artgamme_aga gam on art.art_aga_id = gam.aga_id order by famille_id, collection_id, gamme_id;

        List<RemiseBrut> remisesOfClient = remiseDao.getByClientId(clientId);

        List<RemiseCombinaison> combinaisons = remiseCombinaisonDao.getAllRemiseCombinaisons();
        Map<String, WebixTreeNode> results = new HashMap<>();

        for (RemiseCombinaison combinaison : combinaisons) {
            Integer familleId = combinaison.getFamilleId();
            WebixTreeNode famille = results.get(familleId.toString());
            if (famille == null) {
                WebixTreeNode newFamille = new WebixTreeNode(familleId.toString(), combinaison.getFamilleLibelle());
                results.put(familleId.toString(), newFamille);
                famille = newFamille;
            }

            Map<String, WebixTreeNode> hashedCollections = famille.getHashedData();
            String collectionId = familleId + "-" + combinaison.getCollectionId();
            WebixTreeNode collection  = hashedCollections.get(collectionId);
            if (collection == null) {
                WebixTreeNode newCollection = new WebixTreeNode(collectionId, combinaison.getCollectionLibelle());
                famille.getHashedData().put(collectionId, newCollection);
                famille.getData().add(newCollection);
                collection = newCollection;
            }

            Map<String, WebixTreeNode> hashedGammes = collection.getHashedData();
            String gammeId = familleId + "-" + collectionId + "-" + combinaison.getGammeId();
            WebixTreeNode gamme = hashedGammes.get(gammeId);
            if (gamme == null) {
                WebixTreeNode newGamme = new WebixTreeNode(gammeId, combinaison.getGammeLibelle());
                collection.getHashedData().put(gammeId, newGamme);
                collection.getData().add(newGamme);
                gamme = newGamme;
            }

            Map<String, WebixTreeNode> hashedArticles = gamme.getHashedData();
            String articleId = familleId + "-" + collectionId + "-" + gammeId + "-" + combinaison.getArticleId();
            WebixTreeNode article = hashedArticles.get(articleId);
            if (article== null) {
                WebixTreeNode newArticle = new WebixTreeNode(articleId, combinaison.getArticleLibelle());
                gamme.getHashedData().put(articleId, newArticle);
                gamme.getData().add(newArticle);
                article = newArticle;
            }
        }
        return new ArrayList<WebixTreeNode>(results.values());
//
//
//        HashMap<String, RemiseBrut> mapRemisesOfClient = new HashMap<>();
//
//
//
//
//
//
//        for (RemiseBrut remise : remisesOfClient) {
//            String key = remise.getFamilleArticleId() + "-" + remise.getCollectionArticleId() + "-" + remise.getGammeArticleId() + "-" + remise.getArticleId();
//            mapRemisesOfClient.put(key, remise);
//        }
//
//        Iterable<FamilleArticle> familleArticles = familleArticleDao.findAll();
//
//        Iterable<GammeArticle> gammeArticles = gammeArticleDao.findAll();
//
//        List<WebixTreeNode> results = new ArrayList<>();
//
//        String[] nodeIds = null;
//        if (nodeId != null) {
//            nodeIds = nodeId.split("-");
//        }
//        // level 0 => racine; load only familles
//        // level 1 => famille clicked; load collections
//        // level 2 => collection clicked; load gammes
//        // level 3 => gamme clicked; load articles;
//        final Integer level = nodeIds == null ? 0 : nodeIds.length;
//
//        // level 0 => racine; load only familles
//        if (level >= 0 && familleArticles != null) {
//            // Familles des articles
//            String[] finalNodeIds = nodeIds;
//            familleArticles.forEach(famille -> {
//                Integer nbCollections = famille.getCollections() == null ? 0 : famille.getCollections().size();
//                WebixTreeNode nodeFamille = new WebixTreeNode(famille.getId().toString(), famille.getLibelle() + " (" + nbCollections + ")", false);
//
//                if (mapRemisesOfClient.get(famille.getId()+"-0-0-0") != null) {
//                    nodeFamille.setValue("<span class='remised'>"+famille.getLibelle() + " (" + nbCollections + ")" + "</span>");
//                }
//
//                // level 1 => famille clicked; load collections
//                if (level >= 1 && famille.getCollections() != null && !famille.getCollections().isEmpty()) {
//                    Integer clickedFamilleId = Integer.valueOf(finalNodeIds[0]);
//                    if (famille.getId().equals(clickedFamilleId)) {
//                        // Collections des articles
//                        List<WebixTreeNode> collections = new ArrayList<>();
//                        for (CollectionArticle collection : famille.getCollections()) {
//                            WebixTreeNode nodeCollection = new WebixTreeNode(famille.getId() + "-" + collection.getId(), collection.getDesignation());
//
//                            if (mapRemisesOfClient.get("0-"+collection.getId()+"-0-0") != null) {
//                                nodeCollection.setValue("<span class='remised'>" + collection.getDesignation() + "</span>");
//                            }
//
//                            // level 2 => collection clicked; load gammes
//                            if (level >= 2 && gammeArticles != null) {
//                                Integer clickedCollection = Integer.valueOf(finalNodeIds[1]);
//                                if (!collection.getId().equals(clickedCollection)) {
//                                    continue;
//                                }
//
//                                // Gammes des articles
//                                List<WebixTreeNode> gammes = new ArrayList<>();
//                                gammeArticles.forEach(gamme -> {
//
//                                    // Articles of famille-collection-gamme
//                                    // level 3 => gamme clicked; load articles;
//                                    List<Article> articlesOfGamme = articleDao.findByCollectionAndGamme(collection, gamme);
//                                    if (articlesOfGamme != null && articlesOfGamme.size() > 0) {
//                                        WebixTreeNode gammeNode = new WebixTreeNode(famille.getId() + "-" + collection.getId() + "-" + gamme.getId(), gamme.getDesignation() + " (" + articlesOfGamme.size() + ")");
//                                        List<WebixTreeNode> articles = new ArrayList<>();
//                                        if (level >= 3) {
//                                            Integer clickedGamme = Integer.valueOf(finalNodeIds[2]);
//                                            if (gamme.getId().equals(clickedGamme)) {
//                                                for (Article article : articlesOfGamme) {
//                                                    WebixTreeNode articleNode = new WebixTreeNode(famille.getId() + "-" + collection.getId() + "-" + gamme.getId() + "-" + article.getId(), article.getDesignation());
//                                                    articles.add(articleNode);
//                                                }
//                                                gammeNode.setOpen(true);
//                                                gammeNode.setData(articles);
//                                            }
//                                        }
//                                        gammes.add(gammeNode);
//                                    }
//
//                                });
//                                nodeCollection.setOpen(true);
//                                nodeCollection.setData(gammes);
//                            }
//                            collections.add(nodeCollection);
//                        }
//                        nodeFamille.setOpen(true);
//                        nodeFamille.setData(collections);
//                    }
//                }
//                results.add(nodeFamille);
//            });
//        }
//
//        return results;
    }
}
