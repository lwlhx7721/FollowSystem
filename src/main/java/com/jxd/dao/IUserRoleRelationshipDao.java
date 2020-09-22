package com.jxd.dao;

import com.jxd.model.UserRoleRelationship;

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
}
