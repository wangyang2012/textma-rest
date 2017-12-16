package fr.textma.repository;


import fr.textma.model.Article;
import fr.textma.model.RemiseBrut;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArticleDao extends CrudRepository<Article, Integer> {
}
