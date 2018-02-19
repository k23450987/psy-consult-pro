package com.tom.service;

import com.tom.model.Article;
import java.util.List;

public interface ArticleService extends BasicService<Article> {

    int updateWithBLOBs(Article record);

    List<Article> findArticles();
}
