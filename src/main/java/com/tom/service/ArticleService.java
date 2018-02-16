package com.tom.service;

import com.tom.model.Article;

public interface ArticleService extends BasicService<Article> {

    int updateWithBLOBs(Article record);
}
