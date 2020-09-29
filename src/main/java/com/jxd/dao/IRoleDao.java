package com.jxd.dao;

import com.jxd.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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


    /**
     * 获取用户，用户名及用户权限
     * @return 用户登录信息及权限
     */
    List<Map<String,Object>> getUserAndRole(@Param("pageSize")int pageSize, @Param("pageIndex")int pageIndex, @Param("userName")String userName);

    /**
     * 添加权限
     * @param userId 用户编号
     * @param roleId 权限编号
     * @return 是否成功
     */
    boolean addRole(@Param("userId")int userId,@Param("roleId")int roleId);
}
