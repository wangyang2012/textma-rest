package fr.textma.repository;


import fr.textma.model.RemiseBrut;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RemiseBrutDao extends CrudRepository<RemiseBrut, Integer> {
    List<RemiseBrut> getByClientId(Integer clientId);

    RemiseBrut getByClientIdAndFamilleArticleIdAndCollectionArticleIdAndGammeArticleIdAndArticleId(Integer clientId, Integer familleArticleId, Integer collectionArticleId, Integer gammeArticleId, Integer articleId);
}
