package fr.textma.repository;


import fr.textma.model.Article;
import fr.textma.model.CollectionArticle;
import fr.textma.model.GammeArticle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArticleDao extends CrudRepository<Article, Integer> {

    List<Article> findByCollectionAndGamme(CollectionArticle collection, GammeArticle gamme);
}
