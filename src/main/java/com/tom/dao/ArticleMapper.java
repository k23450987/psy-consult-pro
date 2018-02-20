package com.tom.dao;

import com.tom.model.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BasicMapper<Article> {

    /**
     * 更新文章内容时使用
     * @param record 传递的值对象
     * @return 更新的条数
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * 查询所有文章
     * @return 文章列表
     */
    List<Article> findArticles();
}
