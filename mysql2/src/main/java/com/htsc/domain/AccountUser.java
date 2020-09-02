package com.htsc.domain;

import java.io.Serializable;
import java.util.Date;

public class AccountUser implements Serializable {
    private Integer id;
    private User user;
    private Account account;

    public Integer getUid() {
        return account.getUid();
    }
    public void setUid(Integer uid) {
        account.setUid(uid);
    }
    public Double getMoney() {
        return account.getMoney();
    }
    public void setMoney(Double money) {
        account.setMoney(money);
    }
    public String getUserName() {
        return user.getUserName();
    }
    public void setUserName(String name) {
        user.setUserName(name);
    }
    public Integer getUserId() {
        return user.getUserId();
    }
    public void setUserId(Integer id) {
        user.setUserId(id);
    }
    public String getUserSex() {
        return user.getUserSex();
    }
    public void setUserSex(String sex) {
        user.setUserSex(sex);
    }
    public String getUserAddress() {
        return user.getUserAddress();
    }
    public void setUserAddress(String address) {
        user.setUserAddress(address);
    }
    public Date getUserBirthday() {
        return user.getUserBirthday();
    }
    public void setUserBirthday(Date birthday) {
        user.setUserBirthday(birthday);
    }
}
