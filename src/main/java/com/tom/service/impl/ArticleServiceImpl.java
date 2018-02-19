package com.tom.service.impl;

import com.tom.dao.ArticleMapper;
import com.tom.model.Article;
import com.tom.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ArticleServiceImpl extends BasicServiceImpl<Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int updateWithBLOBs(Article record) {
        return articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public List<Article> findArticles() {
        return articleMapper.findArticles();
    }
}
