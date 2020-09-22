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
    @Override
    public List<Role> getRoleByUserId(int UserId) {
        return roleService.getRoleByUserId(UserId);
    }
}
