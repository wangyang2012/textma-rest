package fr.textma.repository;


import fr.textma.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RemiseDao extends CrudRepository<Remise, Integer> {
    List<Remise> getByClient(TeClient cilent);

    @Query("select r from Remise r LEFT JOIN FamilleArticle f ON f.id = r.famille.id WHERE f.id = :familleId")
    Remise getByFamille(@Param("familleId") Integer familleId);
    @Query("select r from Remise r LEFT JOIN CollectionArticle c ON c.id = r.collection.id WHERE c.id = :collectionId")
    Remise getByCollection(@Param("collectionId")Integer collectionId);
    Remise getByGamme(GammeArticle gamme);
    Remise getByArticle(Article article);
}
