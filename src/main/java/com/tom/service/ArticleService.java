package com.tom.service;

import com.tom.model.Article;
import java.util.List;

public interface ArticleService extends BasicService<Article> {

    /**
     * 更新文章内容时使用
     * @param record 传递的值对象
     * @return 更新的条数
     */
    int updateWithBLOBs(Article record);

    /**
     * 查询所有文章
     * @return 文章列表
     */
    List<Article> findArticles();
}
