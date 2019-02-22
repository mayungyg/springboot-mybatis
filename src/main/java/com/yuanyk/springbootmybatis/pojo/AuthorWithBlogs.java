package com.yuanyk.springbootmybatis.pojo;

import java.util.List;

public class AuthorWithBlogs extends Author {
    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "AuthorWithBlogs{" +"author="+ super.toString()+
                " blogs=" + blogs +
                '}';
    }
}
