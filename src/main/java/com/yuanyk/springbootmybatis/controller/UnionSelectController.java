package com.yuanyk.springbootmybatis.controller;

import com.yuanyk.springbootmybatis.pojo.AuthorWithBlogs;
import com.yuanyk.springbootmybatis.pojo.BlogWithAuthor;
import com.yuanyk.springbootmybatis.service.BlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnionSelectController {
    @Autowired
    private BlogService blogService;

    @ApiOperation("嵌套查询,先查blog表拿到autho_id再查author表,2次查询性能慢，n+1问题")
    @RequestMapping(value = "/getBlogWithAuthorById", method = RequestMethod.GET)
    public BlogWithAuthor getBlogWithAuthorById(Integer id) {
        return blogService.getBlogWithAuthorById(id);
    }

    @ApiOperation("推荐使用。嵌套结果，join一次查询")
    @RequestMapping(value = "/getBlogWithAuthorById2", method = RequestMethod.GET)
    public BlogWithAuthor getBlogWithAuthorById2(Integer id) {
        return blogService.getBlogWithAuthorById2(id);
    }

    @ApiOperation("嵌套查询,根据authorId分别查author表和blog表,2次查询性能慢，n+1问题")
    @RequestMapping(value = "/getAuthorWithBlogsById", method = RequestMethod.GET)
    public AuthorWithBlogs getAuthorWithBlogsById(Integer id) {
        return blogService.getAuthorWithBlogsById(id);
    }

    @ApiOperation("推荐使用。嵌套结果,join一次查询再封装")
    @RequestMapping(value = "/getAuthorWithBlogsById2", method = RequestMethod.GET)
    public AuthorWithBlogs getAuthorWithBlogsById2(Integer id) {
        return blogService.getAuthorWithBlogsById2(id);
    }

    @ApiOperation("嵌套查询,测试懒加载（看控制台打印的sql），解决n+1问题")
    @RequestMapping(value = "/getAuthorNameById", method = RequestMethod.GET)
    public String getAuthorNameById(Integer id) {
        return blogService.getAuthorNameById(id);
    }

}
