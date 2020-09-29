package com.jxd.dao;

import com.jxd.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 11:22
 */
public interface IUserDao {
    /**
     * 通过用户id获取用户信息
     * @param userId 用户id
     * @return
     */
    User getUserByUserId(int userId);

    /**
     * 设置用户登录时间(update)
     * @param userId
     * @return
     */
    boolean setLoginTime(@Param("userId") int userId,@Param("loginTime") String loginTime);

    /**
     * 通过用户名和部门获取所有用户
     * @return 部门id改为部门名，其它与User类一致
     */
    List<Map<String,Object>> getAllUsers(@Param("userName") String userName,@Param("deptId") int deptId);

    /**
     * 通过用户名和部门获取所有用户分页查询
     * @return 部门id改为部门名，其它与User类一致
     */
    List<Map<String,Object>> getAllUserByPage(@Param("pageSize") int pageSize,@Param("pageIndex") int pageIndex,@Param("userName") String userName,@Param("deptId") int deptId);

    /**
     * 添加用户（userId，flag，loginTime不作添加）
     * @param user 用户
     * @return 是否添加成功
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
     * @param userId
     * @return
     */
    boolean delUserByUserId(int userId);

    /**
     * 批量删除
     * @param userIds
     * @return
     */
    boolean delUsersByUserId(@Param("userIds") String userIds);

    /**
     * 通过用户名和身份获取所有用户分页查询
     * @return 用户登录信息及权限
     */
    List<Map<String,Object>> getAllUserByRole(@Param("pageSize")int pageSize,@Param("pageIndex")int pageIndex,@Param("userName")String userName,@Param("deptId") int deptId);

    /**
     * 重置密码
     * @param userId 用户Id
     * @param pwd 密码
     * @return 是否成功
     */
    boolean updPwd(@Param("userId") int userId,@Param("pwd") String pwd);

    /**
     * 用户自己修改自己的信息
     * @param user 用户
     * @return 是否成功
     */
    boolean updUserByUser(User user);
}
