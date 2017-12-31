package fr.textma.repository;


import fr.textma.model.RemiseCombinaison;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RemiseCombinaisonDao extends CrudRepository<RemiseCombinaison, Integer> {

    @Query(value="SELECT afa_id famille_id, afa_libelle famille_libelle, acl_id collection_id, acl_designation collection_libelle, aga_id gamme_id, aga_designation gamme_libelle, art_id article_id, art_designation article_libelle, CONCAT(afa_id, \"-\", acl_id, \"-\", aga_id, \"-\", art_id) id FROM textma.te_article_art art join te_artcollection_acl col on art.art_acl_id=col.acl_id join te_artfamille_afa fam on fam.afa_id = col.acl_afa_id join te_artgamme_aga gam on art.art_aga_id = gam.aga_id order by id", nativeQuery = true)
    List<RemiseCombinaison> getAllRemiseCombinaisons();
}
