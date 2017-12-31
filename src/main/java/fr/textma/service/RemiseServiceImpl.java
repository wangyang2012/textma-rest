package fr.textma.service;

import fr.textma.model.RemiseBrut;
import fr.textma.model.RemiseCombinaison;
import fr.textma.model.WebixTreeNode;
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

    /**
     * Function to get all possible reductions from the article table.
     * Each affected reduction will be surround by <span class="remised"></span>
     * To improve: use multithreading in the for loop
     *
     * @param clientId
     * @param nodeId
     * @return
     */
    @Override
    public List<WebixTreeNode> getRemisesByCilent(Integer clientId, String nodeId) {

        // Get all remises of client
        List<RemiseBrut> remisesOfClient = remiseDao.getByClientId(clientId);

        // Get all combinaisons of famille-collection-gamme-article from the article table
        List<RemiseCombinaison> combinaisons = remiseCombinaisonDao.getAllRemiseCombinaisons();

        Map<String, WebixTreeNode> results = new HashMap<>();

        for (RemiseCombinaison combinaison : combinaisons) {
            // Famille
            Integer familleId = combinaison.getFamilleId();
            WebixTreeNode famille = results.get(familleId.toString());
            if (famille == null) {
                WebixTreeNode newFamille = new WebixTreeNode(familleId.toString(), combinaison.getFamilleLibelle());
                results.put(familleId.toString(), newFamille);
                famille = newFamille;
            }
            // Compare with remises of client
            RemiseBrut remiseFamille = findRemiseOfClient(remisesOfClient, "famille", combinaison.getFamilleId());
            if (remiseFamille != null) {
                famille.setValue("<span class='remised'>" + combinaison.getFamilleLibelle() + " # </span>");
            }

            // Collection
            Map<String, WebixTreeNode> hashedCollections = famille.getHashedData();
            String collectionId = familleId + "-" + combinaison.getCollectionId();
            WebixTreeNode collection  = hashedCollections.get(collectionId);
            if (collection == null) {
                WebixTreeNode newCollection = new WebixTreeNode(collectionId, combinaison.getCollectionLibelle());
                famille.getHashedData().put(collectionId, newCollection);
                famille.getData().add(newCollection);
                collection = newCollection;
            }
            RemiseBrut remiseCollection = findRemiseOfClient(remisesOfClient, "collection", combinaison.getCollectionId());
            if (remiseCollection != null) {
                famille.setValue("<span class='remised'>" + combinaison.getFamilleLibelle() + "</span>");
                collection.setValue("<span class='remised'>" + combinaison.getCollectionLibelle() + " # </span>");
            }

            // Gamme
            Map<String, WebixTreeNode> hashedGammes = collection.getHashedData();
            String gammeId = collectionId + "-" + combinaison.getGammeId();
            WebixTreeNode gamme = hashedGammes.get(gammeId);
            if (gamme == null) {
                WebixTreeNode newGamme = new WebixTreeNode(gammeId, combinaison.getGammeLibelle());
                collection.getHashedData().put(gammeId, newGamme);
                collection.getData().add(newGamme);
                gamme = newGamme;
            }
            RemiseBrut remiseGamme = findRemiseOfClient(remisesOfClient, "gamme", combinaison.getGammeId());
            if (remiseGamme != null) {
                famille.setValue("<span class='remised'>" + combinaison.getFamilleLibelle() + "</span>");
                collection.setValue("<span class='remised'>" + combinaison.getCollectionLibelle() + "</span>");
                gamme.setValue("<span class='remised'>" + combinaison.getGammeLibelle() + " # </span>");
            }

            // Article
            Map<String, WebixTreeNode> hashedArticles = gamme.getHashedData();
            String articleId = gammeId + "-" + combinaison.getArticleId();
            WebixTreeNode article = hashedArticles.get(articleId);
            if (article== null) {
                WebixTreeNode newArticle = new WebixTreeNode(articleId, combinaison.getArticleLibelle());
                gamme.getHashedData().put(articleId, newArticle);
                gamme.getData().add(newArticle);
                article = newArticle;
            }
            RemiseBrut remiseArticle = findRemiseOfClient(remisesOfClient, "article", combinaison.getArticleId());
            if (remiseArticle != null) {
                famille.setValue("<span class='remised'>" + combinaison.getFamilleLibelle() + "</span>");
                collection.setValue("<span class='remised'>" + combinaison.getCollectionLibelle() + "</span>");
                gamme.setValue("<span class='remised'>" + combinaison.getGammeLibelle() + "</span>");
                article.setValue("<span class='remised'>" + combinaison.getArticleLibelle() + " # </span>");
            }
        }
        return new ArrayList<WebixTreeNode>(results.values());
    }

    // To improve: use HashMap or MapReduce for searchById
    private RemiseBrut findRemiseOfClient(List<RemiseBrut> remisesOfClient, String field, Integer id) {
        for (RemiseBrut remise : remisesOfClient) {
            switch(field) {
                case "famille":
                    if (remise.getFamilleArticleId().equals(id)) {
                        return remise;
                    }
                    break;
                case "collection":
                    if (remise.getCollectionArticleId().equals(id)) {
                        return remise;
                    }
                    break;
                case "gamme":
                    if (remise.getGammeArticleId().equals(id)) {
                        return remise;
                    }
                    break;
                case "article":
                    if (remise.getArticleId().equals(id)) {
                        return remise;
                    }
                    break;
            }
        }
        return null;
    }
}
