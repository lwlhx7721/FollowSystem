package com.jxd.service;

import com.jxd.model.User;

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
}
