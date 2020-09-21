package com.jxd.dao;

import com.jxd.model.UserRoleRelationship;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 14:13
 */
public interface IUserRoleRelationshipDao {
    /**
     * 通过用户id获取用户权限
     * @param userId 用户id
     * @return
     */
    UserRoleRelationship getUserRoleRelationshipByUserId(int userId);
}
