package com.jxd.service;

import com.jxd.model.UserRoleRelationship;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 14:16
 */
public interface IUserRoleRelationshipService {
    /**
     * 通过用户id获取用户权限
     * @param userId 用户id
     * @return
     */
    List<Map<String,Object>> getUserRoleRelationshipByUserId(int userId);

    /**
     * 获取所有的对应关系
     * @return 结果集
     */
    List<UserRoleRelationship> getAllUserRole();

    /**
     * 添加权限
     * @param userID 用户id
     * @param roleId 权限id
     * @return 是否成功
     */
    boolean addRole(int userID,int roleId);

    /**
     * 收回权限
     * @param userId 用户id
     * @param roleId 用户权限
     * @return 是否成功
     */
    boolean delRole(int userId,int roleId);
}
