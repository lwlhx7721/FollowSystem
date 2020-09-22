package com.jxd.service.impl;

import com.jxd.model.Role;
import com.jxd.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-22 10:09
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleService roleService;

    /**
     * 三表连接查询，通过user表userId查询出userrolerelationship
     * 表中所有的roleId（user.userId = userrolerelationship.userId），
     * 再将符合要求的roleId当做条件查询出role表的所有信息
     * @param UserId 用户ID
     * @return 符合条件的角色信息
     */
    @Override
    public List<Role> getRoleByUserId(int UserId) {
        return roleService.getRoleByUserId(UserId);
    }
}
