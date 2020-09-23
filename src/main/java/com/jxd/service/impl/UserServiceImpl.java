package com.jxd.service.impl;

import com.jxd.dao.IUserDao;
import com.jxd.model.User;
import com.jxd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 通过用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public boolean setLoginTime(int userId) {
        return false;
    }

    @Override
    public List<Map<String, Object>> getAllUsers(String userName, int deptId) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getAllUserByPage(int pageSize, int pageIndex, String userName, int deptId) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updUser(User user) {
        return false;
    }

    @Override
    public boolean delUserByUserId(int userId) {
        return false;
    }

    @Override
    public boolean delUsersByUserId(String userIds) {
        return false;
    }

}
