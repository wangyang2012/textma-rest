package fr.textma.repository;


import fr.textma.model.RemiseCombinaison;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RemiseCombinaisonDao extends CrudRepository<RemiseCombinaison, Integer> {

    @Query(value="SELECT CONCAT(fam.afa_id, \"-\", col.acl_id, \"-\", gam.aga_id) id, fam.afa_id famille_id, fam.afa_libelle famille_libelle, art.art_acl_id collection_id, col.acl_designation collection_libelle, art.art_aga_id gamme_id, gam.aga_designation gamme_libelle, count(*) count FROM textma.te_article_art art join te_artcollection_acl col on art.art_acl_id=col.acl_id join te_artfamille_afa fam on fam.afa_id = col.acl_afa_id join te_artgamme_aga gam on art.art_aga_id = gam.aga_id group by art_acl_id, art_aga_id order by famille_id, collection_id, gamme_id", nativeQuery = true)
    List<RemiseCombinaison> getAllRemiseCombinaisons();
}
