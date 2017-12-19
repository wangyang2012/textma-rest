package fr.textma.repository;


import fr.textma.model.GammeArticle;
import org.springframework.data.repository.CrudRepository;


public interface GammeArticleDao extends CrudRepository<GammeArticle, Integer> {
}
