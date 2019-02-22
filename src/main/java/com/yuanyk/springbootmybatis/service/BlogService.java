package com.yuanyk.springbootmybatis.service;

import com.yuanyk.springbootmybatis.mapper.AuthorWithBlogsMapper;
import com.yuanyk.springbootmybatis.mapper.BlogWithAuthorMapper;
import com.yuanyk.springbootmybatis.pojo.AuthorWithBlogs;
import com.yuanyk.springbootmybatis.pojo.BlogWithAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogWithAuthorMapper blogWithAuthorMapper;

    @Autowired
    private AuthorWithBlogsMapper authorWithBlogsMapper;

    public BlogWithAuthor getBlogWithAuthorById(Integer id){
        return blogWithAuthorMapper.selectBlogWithAuthor(id);
    }
    public BlogWithAuthor getBlogWithAuthorById2(Integer id){
        return blogWithAuthorMapper.selectBlogWithAuthor2(id);
    }

    public AuthorWithBlogs getAuthorWithBlogsById(Integer id){
        return authorWithBlogsMapper.selectAuthorWithBlogs(id);
    }
    public AuthorWithBlogs getAuthorWithBlogsById2(Integer id){
        return authorWithBlogsMapper.selectAuthorWithBlogs2(id);
    }
    public String getAuthorNameById(Integer id){
        // 开启懒加载后不会查询blog表
        return authorWithBlogsMapper.selectAuthorWithBlogs(id).getNickname();
    }
}
