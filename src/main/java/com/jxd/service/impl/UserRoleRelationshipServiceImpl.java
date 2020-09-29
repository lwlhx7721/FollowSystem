package com.jxd.service.impl;

import com.jxd.dao.IUserRoleRelationshipDao;
import com.jxd.model.UserRoleRelationship;
import com.jxd.service.IUserRoleRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-21 14:41
 */
@Service
public class UserRoleRelationshipServiceImpl implements IUserRoleRelationshipService {
    @Autowired
    private IUserRoleRelationshipDao userRoleRelationshipDao;

    /**
     * 通过用户id获取用户权限
     * @param userId 用户id
     * @return 用户角色分配信息
     */
    @Override
    public List<Map<String,Object>> getUserRoleRelationshipByUserId(int userId) {
        return userRoleRelationshipDao.getUserRoleRelationshipByUserId(userId);
    }
    /**
     * 获取所有的对应关系
     * @return 结果集
     */
    @Override
    public List<UserRoleRelationship> getAllUserRole() {
        return userRoleRelationshipDao.getAllUserRole();
    }
    /**
     * 添加权限
     * @param userId，用户编号
     * @param roleId 权限编号
     * @return 是否成功
     */
    @Override
    public boolean addRole(int userId,int roleId) {
        return userRoleRelationshipDao.addRole(userId, roleId);
    }
    /**
     * 收回权限
     * @param userId 用户id
     * @param roleId 用户权限
     * @return 是否成功
     */
    @Override
    public boolean delRole(int userId, int roleId) {
        return userRoleRelationshipDao.delRole(userId, roleId);
    }


}
