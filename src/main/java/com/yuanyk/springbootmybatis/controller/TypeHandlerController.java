package com.yuanyk.springbootmybatis.controller;

import com.yuanyk.springbootmybatis.pojo.SysUser;
import com.yuanyk.springbootmybatis.service.UserService;
import com.yuanyk.springbootmybatis.vo.UserAddVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeHandlerController {

    @Autowired
    UserService userService;

    @ApiOperation("测试TypeHandler,查询时在nickname后面插入字符串：select")
    @RequestMapping(value = "/getByIdUseTypeHandler", method = RequestMethod.GET)
    public SysUser getByIdUseTypeHandler(Integer id) {
        return userService.getByIdUseTypeHandler(id);
    }


    @ApiOperation("测试TypeHandler，插入时在nickname前添加字符串：insert")
    @ApiImplicitParam(name = "vo", value = "查询参数", dataType = "UserAddVo", paramType = "body", required = true)
    @RequestMapping(value = "/insertUseTypeHandler", method = RequestMethod.POST)
    public SysUser insertUseTypeHandler(@RequestBody UserAddVo vo) {
        return userService.insertUseTypeHandler(vo);
    }

}
