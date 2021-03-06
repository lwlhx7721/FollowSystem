package com.jxd.service.impl;

import com.jxd.dao.IRoleDao;
import com.jxd.model.Role;
import com.jxd.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-22 10:09
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    /**
     * 三表连接查询，通过user表userId查询出userrolerelationship
     * 表中所有的roleId（user.userId = userrolerelationship.userId），
     * 再将符合要求的roleId当做条件查询出role表的所有信息
     * @param UserId 用户ID
     * @return 符合条件的角色信息
     */
    @Override
    public List<Role> getRoleByUserId(int UserId) {
        return roleDao.getRoleByUserId(UserId);
    }
    /**
     * 获取所有身份信息
     * @return 身份信息
     */
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
    /**
     * 获取用户，用户名及用户权限
     * @return 用户登录信息及权限
     */
    @Override
    public List<Map<String, Object>> getUserAndRole(int pageSize, int pageIndex, String userName) {
        int PageIndex = (pageIndex - 1) * pageSize;
        return roleDao.getUserAndRole(pageSize, PageIndex, userName);
    }

    /**
     * 添加权限
     * @param userId，用户编号
     * @param roleId 权限编号
     * @return 是否成功
     */
    @Override
    public boolean addRole(int userId,int roleId) {
        return roleDao.addRole(userId, roleId);
    }
}
