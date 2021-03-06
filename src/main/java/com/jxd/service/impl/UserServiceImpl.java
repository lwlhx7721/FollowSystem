package com.jxd.service.impl;

import com.jxd.dao.IUserDao;
import com.jxd.dao.IUserRoleRelationshipDao;
import com.jxd.model.User;
import com.jxd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-21 14:38
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserRoleRelationshipDao userRoleRelationshipDao;

    /**
     * 通过用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }

    /**
     * 设置用户登录时间(insert),service层获取现在的系统时间，
     * 调用dao层的setLoginTime(int userId,String loginTime)
     * @param userId
     * @return
     */
    @Override
    public boolean setLoginTime(int userId) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String insert = sf.format(date);
        return userDao.setLoginTime(userId, insert);
    }

    /**
     * 通过用户名和部门获取所有用户
     * @return 部门id改为部门名，其它与User类一致
     */
    @Override
    public List<Map<String, Object>> getAllUsers(String userName, int deptId) {
        return userDao.getAllUsers(userName,deptId);
    }

    @Override
    public List<Map<String, Object>> getAllUserByPage(int pageSize, int pageIndex, String userName, int deptId) {
        int index = (pageIndex - 1) * pageSize;
        return userDao.getAllUserByPage(pageSize,index,userName,deptId);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updUser(User user) {
        return userDao.updUser(user);
    }

    @Override
    public boolean delUserByUserId(int userId) {
        userRoleRelationshipDao.delUserRoleRelationshipByUserId(userId);
        boolean isDel = userDao.delUserByUserId(userId);
        return isDel;
    }

    @Override
    public boolean delUsersByUserId(String userIds) {
        boolean isDel = false;
        try{
            userRoleRelationshipDao.delUserRoleRelationshipsByUserId(userIds);
            isDel = userDao.delUsersByUserId(userIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDel;
    }


    /**
     * 通过用户名和身份获取所有用户分页查询
     * @return 用户登录信息及权限
     */
    @Override
    public List<Map<String, Object>> getAllUserByRole(int pageSize, int pageIndex, String userName, int deptId) {
        int PageIndex = (pageIndex - 1) * pageSize;
        return userDao.getAllUserByRole(pageSize,PageIndex,userName,deptId);
    }
    /**
     * 重置密码
     * @param userId 用户Id
     * @param pwd 密码
     * @return 是否成功
     */
    @Override
    public boolean updPwd(int userId, String pwd) {
        return userDao.updPwd(userId,pwd);
    }

    /**
     * 用户自己修改自己的信息
     * @param user 用户
     * @return 是否成功
     */
    @Override
    public boolean updUserByUser(User user) {
        return userDao.updUserByUser(user);
    }
}
