package com.jxd.service;

import com.jxd.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 11:21
 */
public interface IUserService {
    /**
     * 通过用户id获取用户信息
     * @param userId 用户id
     * @return
     */
    User getUserByUserId(int userId);

    /**
     * 设置用户登录时间(insert),service层获取现在的系统时间，
     * 调用dao层的setLoginTime(int userId,String loginTime)
     * @param userId
     * @return
     */
    boolean setLoginTime(int userId);

    /**
     * 通过用户名和部门获取所有用户
     * @return 部门id改为部门名，其它与User类一致
     */
    List<Map<String,Object>> getAllUsers(String userName,int deptId);

    /**
     * 通过用户名和部门获取所有用户分页查询
     * @return 部门id改为部门名，其它与User类一致
     */
    List<Map<String,Object>> getAllUserByPage(int pageSize,int pageIndex,String userName,int deptId);

    /**
     * 添加用户（userId，flag，loginTime不作添加）
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 通过userId修改用户信息（userId，flag，loginTime不作修改）
     * @param user
     * @return
     */
    boolean updUser(User user);

    /**
     * 通过userId删除用户，service层处理存在userRoleRelationShip表的外键关联，
     * 先将userRoleRelationShip的userId相同的删掉
     * 调用userRoleRelationShip的dao层的方法
     * @param userId
     * @return
     */
    boolean delUserByUserId(int userId);

    /**
     * 批量删除(service同样需要先处理UserRoleRelationship表的数据
     * @param userIds
     * @return
     */
    boolean delUsersByUserId(String userIds);

    /**
     * 通过用户名和身份获取所有用户分页查询
     * @return 用户登录信息及权限
     */
    List<Map<String,Object>> getAllUserByRole(int pageSize,int pageIndex,String userName,int roleId);

    /**
     * 用户自己修改自己的信息
     * @param user 用户
     * @return 是否成功
     */
    boolean updUserByUser(User user);
}
