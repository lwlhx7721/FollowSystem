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
     *
     * @param userId 用户id
     * @return 用户角色关系信息
     */
    @Override
    public List<Map<String,Object>> getUserRoleRelationshipByUserId(int userId) {
        return userRoleRelationshipDao.getUserRoleRelationshipByUserId(userId);
    }
}
