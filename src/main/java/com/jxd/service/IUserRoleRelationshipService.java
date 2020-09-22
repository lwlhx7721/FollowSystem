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
}
