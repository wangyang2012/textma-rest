package fr.textma.repository;


import fr.textma.model.RemiseCombinaison;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RemiseCombinaisonDao extends CrudRepository<RemiseCombinaison, Integer> {

    @Query(value="SELECT afa_id familleId, afa_libelle familleLibelle, acl_id collectionId, acl_designation collectionLibelle, aga_id gammeId, aga_designation gammeLibelle, art_id articleId, art_designation articleLibelle, CONCAT(afa_id, \"-\", acl_id, \"-\", aga_id, \"-\", art_id) id FROM textma.te_article_art art join te_artcollection_acl col on art.art_acl_id=col.acl_id join te_artfamille_afa fam on fam.afa_id = col.acl_afa_id join te_artgamme_aga gam on art.art_aga_id = gam.aga_id order by id", nativeQuery = true)
    List<RemiseCombinaison> getAllRemiseCombinaisons();
}
