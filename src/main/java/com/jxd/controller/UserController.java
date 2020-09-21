package com.jxd.controller;

import com.jxd.model.User;
import com.jxd.model.UserRoleRelationship;
import com.jxd.service.IUserRoleRelationshipService;
import com.jxd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 09:46
 */
@Controller
@SessionAttributes({"user","userRoleRelationship"})
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleRelationshipService userRoleRelationshipService;

    /**
     * 获取登录状态，根据用户名密码连接数据库（用户表，用户权限表），正确后生成map对象，
     * 存（用户对象，用户权限对象），存到session里面，完善后修改注释
     * @param userId 前台传递的用户名
     * @param pwd 前台传递密码
     * @param model
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(int userId, String pwd, Model model) {
        User user = userService.getUserByUserId(userId);
        if(user == null) {
            return "userIsNotFound";
        }
        if(pwd == null || !pwd.equals(user.getPwd())) {
            return "pwdError";
        }
        UserRoleRelationship userRoleRelationship = userRoleRelationshipService.getUserRoleRelationshipByUserId(userId);
        model.addAttribute("user",user);
        model.addAttribute("userRoleRelationship",userRoleRelationship);
        return "index";
    }
}
