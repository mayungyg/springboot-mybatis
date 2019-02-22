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
public class BaseController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "新增用户,插入成功后，将自增的主键赋值给id字段")
    @ApiImplicitParam(name = "vo", value = "查询参数", dataType = "UserAddVo", paramType = "body", required = true)
    @RequestMapping(value = "/insertReturnAutoId", method = RequestMethod.POST)
    public Object insertReturnAutoId(@RequestBody UserAddVo vo) {
        return userService.insert(vo);
    }


    @ApiOperation("根据id查询")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public SysUser getById(Integer id) {
        return userService.getById(id);
    }


}
