package com.yuanyk.springbootmybatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanyk.springbootmybatis.mapper.MyUserMapper;
import com.yuanyk.springbootmybatis.mapper.SysUserMapper;
import com.yuanyk.springbootmybatis.pojo.SysUser;
import com.yuanyk.springbootmybatis.pojo.SysUserExample;
import com.yuanyk.springbootmybatis.vo.UserAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    MyUserMapper myUserMapper;

    public SysUser getById(Integer uid){
        return sysUserMapper.selectByPrimaryKey(uid);
    }

    public SysUser insert(UserAddVo vo){
        SysUser user = vo.change();
        myUserMapper.insert(user);
        return user;
    }

    public PageInfo<SysUser> pageByPageHelper(int pageIndex, int pageSize){
        PageHelper.startPage(pageIndex, pageSize);
        List<SysUser> users = sysUserMapper.selectByExample(new SysUserExample());
        PageInfo<SysUser> info = new PageInfo<>(users);
        return info;
    }

    public List<SysUser> pageByLimitClause(int pageIndex, int pageSize){
        SysUserExample example = new SysUserExample();
        int skip = (pageIndex-1)*pageSize;
        example.setLimitClause(String.format("%s,%s",skip,pageSize));
        return  sysUserMapper.selectByExample(example);
    }

    public SysUser insertUseTypeHandler(UserAddVo vo){
        SysUser user = vo.change();
        myUserMapper.insertUseTypeHandler(user);
        return getById(user.getId());
    }

    public SysUser getByIdUseTypeHandler(Integer id){

        return  myUserMapper.selectByIdUseTypeHandler(id);
    }
    public void update(SysUser user){
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    public void insertBatch(List<UserAddVo> list){
        List<SysUser> users = list.stream().map(vo -> vo.change()).collect(Collectors.toList());
        myUserMapper.insertBatch(users);
    }

    @Transactional
    public void insertBatch2(List<UserAddVo> list){
        List<SysUser> users = list.stream().map(vo -> vo.change()).collect(Collectors.toList());
        for(SysUser user:users){
            sysUserMapper.insertSelective(user);
        }
    }
}
