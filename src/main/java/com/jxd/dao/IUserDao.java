package com.jxd.dao;

import com.jxd.model.User;

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
}
