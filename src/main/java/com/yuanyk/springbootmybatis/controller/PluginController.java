package com.yuanyk.springbootmybatis.controller;

import com.yuanyk.springbootmybatis.pojo.SysUser;
import com.yuanyk.springbootmybatis.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PluginController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "测试plugin,更新前&后在控制台打印cql")
    @ApiImplicitParam(name = "vo", value = "参数", dataType = "SysUser", paramType = "body", required = true)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody SysUser vo) {
        userService.update(vo);
        return "update success";
    }

}
