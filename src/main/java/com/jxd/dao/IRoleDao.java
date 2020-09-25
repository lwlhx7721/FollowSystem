package com.jxd.dao;

import com.jxd.model.Role;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-22 09:57
 */
public interface IRoleDao {
    /**
     * 三表连接查询，通过user表userId查询出userrolerelationship
     * 表中所有的roleId（user.userId = userrolerelationship.userId），
     * 再将符合要求的roleId当做条件查询出role表的所有信息
     * @param UserId
     * @return
     */
    List<Role> getRoleByUserId(int UserId);

    /**
     * 获取所有身份信息
     * @return 身份信息
     */
    List<Role> getAllRole();
}
