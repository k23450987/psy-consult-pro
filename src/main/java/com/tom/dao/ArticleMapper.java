package com.tom.dao;

import com.tom.model.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BasicMapper<Article> {

    int updateByPrimaryKeyWithBLOBs(Article record);
}
