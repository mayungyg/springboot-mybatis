package com.yuanyk.springbootmybatis.controller;

import com.yuanyk.springbootmybatis.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @Autowired
    UserService userService;

    @ApiOperation("pagehelper分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页数1开始", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页最大记录数", dataType = "Integer", paramType = "query", required = true)
    })
    @RequestMapping(value = "/pageByPageHelper", method = RequestMethod.POST)
    public Object pageByPageHelper(int pageIndex, int pageSize) {
        return userService.pageByPageHelper(pageIndex, pageSize);
    }

    @ApiOperation("sql拼接 limit 分页查询,仅限于mysql数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页数1开始", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页最大记录数", dataType = "Integer", paramType = "query", required = true)
    })
    @RequestMapping(value = "/pageByLimitClause", method = RequestMethod.POST)
    public Object pageByLimitClause(int pageIndex, int pageSize) {
        return userService.pageByLimitClause(pageIndex, pageSize);
    }


}
