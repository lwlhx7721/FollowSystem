package com.jxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 09:46
 */
@Controller
public class UserController {
    /**
     * 获取登录状态，根据用户名密码连接数据库（用户表，用户权限表），正确后生成map对象，
     * 存（用户对象，用户权限对象），存到session里面，完善后修改注释
     * @param username 前台传递的用户名
     * @param pwd 前台传递密码
     * @param model
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String pwd, Model model) {
        return "admin";
    }
}
