package com.htsc.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer roleld;
    private String roleName;
    private String roleDesc;

    private List<User> users;

    public Integer getRoleld() {
        return roleld;
    }

    public void setRoleld(Integer roleld) {
        this.roleld = roleld;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleld=" + roleld +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }
}
