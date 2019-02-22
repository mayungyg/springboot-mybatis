package com.yuanyk.springbootmybatis.mapper;

import com.yuanyk.springbootmybatis.pojo.AuthorWithBlogs;
import com.yuanyk.springbootmybatis.pojo.Blog;

import java.util.List;

public interface AuthorWithBlogsMapper {

    AuthorWithBlogs selectAuthorWithBlogs(Integer id);

    List<Blog> selectBlogByAuthorId(Integer authorId);

    AuthorWithBlogs selectAuthorWithBlogs2(Integer authorId);


}