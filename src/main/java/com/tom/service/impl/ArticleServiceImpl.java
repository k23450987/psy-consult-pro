package com.tom.service.impl;

import com.tom.dao.ArticleMapper;
import com.tom.model.Article;
import com.tom.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends BasicServiceImpl<Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int updateWithBLOBs(Article record) {
        return articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }
}