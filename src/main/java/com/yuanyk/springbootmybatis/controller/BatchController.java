package com.yuanyk.springbootmybatis.controller;

import com.yuanyk.springbootmybatis.service.UserService;
import com.yuanyk.springbootmybatis.vo.UserAddVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatchController {

    @Autowired
    UserService userService;

    @ApiOperation("批量插入-->拼接sql。速度快，但mysql对sql的长度有限制")
    @ApiImplicitParam(name = "vo", value = "查询参数", allowMultiple = true, dataType = "UserAddVo", paramType = "body", required = true)
    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public Object insertBatch(@RequestBody List<UserAddVo> vo) {
        userService.insertBatch(vo);
        return "success";
    }

    @ApiOperation("批量插入-->添加事物，遍历集合，一个一个插入。每保存一条记录都需要与数据库建立连接，速度慢")
    @ApiImplicitParam(name = "vo", value = "查询参数", allowMultiple = true, dataType = "UserAddVo", paramType = "body", required = true)
    @RequestMapping(value = "/insertBatch2", method = RequestMethod.POST)
    public Object insertBatch2(@RequestBody List<UserAddVo> vo) {
        userService.insertBatch2(vo);
        return "success";
    }


}
