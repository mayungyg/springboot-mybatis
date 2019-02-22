package com.yuanyk.springbootmybatis.vo;

import com.yuanyk.springbootmybatis.pojo.SysUser;

public class UserAddVo {
    private String account;

    private String password;

    private String phone;

    private String email;

    private String nickname;

    private String salt;

    public SysUser change(){
        SysUser user = new SysUser();
        user.setAccount(getAccount());
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setSalt(getSalt());
        user.setNickname(getNickname());
        user.setPhone(getPhone());
        return user;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
