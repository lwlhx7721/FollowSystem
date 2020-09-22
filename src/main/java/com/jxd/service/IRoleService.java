package com.jxd.service;

import com.jxd.model.Role;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-22 10:02
 */
public interface IRoleService {
    /**
     * 三表连接查询，通过user表userId查询出userrolerelationship
     * 表中所有的roleId（user.userId = userrolerelationship.userId），
     * 再将符合要求的roleId当做条件查询出role表的所有信息
     * @param UserId
     * @return
     */
    List<Role> getRoleByUserId(int UserId);
}
