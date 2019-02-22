package com.yuanyk.springbootmybatis.mapper;

import com.yuanyk.springbootmybatis.pojo.SysUser;
import com.yuanyk.springbootmybatis.pojo.SysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyUserMapper {

    int insert(SysUser record);

    int insertUseTypeHandler(SysUser record);

    SysUser selectByIdUseTypeHandler(Integer id);

    int insertBatch(List<SysUser> list);

}