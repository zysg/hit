package com.htsc.domain;

import java.io.Serializable;
import java.util.Date;

public class AccountUser implements Serializable {
    private Integer id;
    private User user;
    private Account account;

    public AccountUser() {
        this.account = new Account();
        this.user = new User();
    }

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
    public Integer getId() {
        return user.getUserId();
    }
    public void setId(Integer id) {
        user.setUserId(id);
    }
    public String getSex() {
        return user.getUserSex();
    }
    public void setSex(String sex) {
        user.setUserSex(sex);
    }
    public String getAddress() {
        return user.getUserAddress();
    }
    public void setAddress(String address) {
        user.setUserAddress(address);
    }
    public Date getBirthday() {
        return user.getUserBirthday();
    }
    public void setBirthday(Date birthday) {
        user.setUserBirthday(birthday);
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", user=" + user +
                ", account=" + account +
                '}';
    }
}
