package com.yuanyk.springbootmybatis.mapper;

import com.yuanyk.springbootmybatis.pojo.Author;
import com.yuanyk.springbootmybatis.pojo.BlogWithAuthor;

public interface BlogWithAuthorMapper {

    Author selectAuthorById(Integer id);

    BlogWithAuthor selectBlogWithAuthor(Integer id);

    BlogWithAuthor selectBlogWithAuthor2(Integer id);

}