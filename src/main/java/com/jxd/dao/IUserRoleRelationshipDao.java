package com.jxd.dao;

import com.jxd.model.UserRoleRelationship;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 14:13
 */
public interface IUserRoleRelationshipDao {
    /**
     * 通过用户id获取用户角色id,角色名
     * @param userId 用户id
     * @return
     */
    List<Map<String,Object>> getUserRoleRelationshipByUserId(int userId);

    /**
     * 删除userId为此的用户角色分配表中的信息
     * @param userId
     * @return
     */
    boolean delUserRoleRelationshipByUserId(int userId);

    /**
     * 批量删除
     * @param userIds
     * @return
     */
    boolean delUserRoleRelationshipsByUserId(@Param("userIds") String userIds);

    /**
     * 获取所有的对应关系
     * @return 结果集
     */
    List<UserRoleRelationship> getAllUserRole();

    /**
     * 添加权限
     * @param userId 用户编号
     * @param roleId 权限编号
     * @return 是否成功
     */
    boolean addRole(@Param("userId")int userId,@Param("roleId")int roleId);

    /**
     * 收回权限
     * @param userId 用户id
     * @param roleId 用户权限
     * @return 是否成功
     */
    boolean delRole(int userId,int roleId);
}
