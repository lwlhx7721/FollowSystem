package com.jxd.model;

/**
 * @author LuWenlong
 * @description 用户角色分配
 * @date 2020-09-21 11:19
 */
public class UserRoleRelationship {
        /**
         *用户id
         */
     private int userId;
        /**
         *角色id
         */
     private int roleId;

    public UserRoleRelationship() {
    }

    public UserRoleRelationship(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRoleRelationship(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
