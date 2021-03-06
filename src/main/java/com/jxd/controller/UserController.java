package com.jxd.controller;

import com.jxd.model.ListData;
import com.jxd.model.Role;
import com.jxd.model.User;
import com.jxd.service.IDeptService;
import com.jxd.service.IRoleService;
import com.jxd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 09:46
 */
@Controller
@SessionAttributes({"loginUser","roles","role"})
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IDeptService deptService;

    /**
     *
     * @param userId
     * @param pwd
     * @param rememberPwd
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(int userId, String pwd, int rememberPwd, Model model, HttpServletResponse response) {
        User user = userService.getUserByUserId(userId);
        if(user == null) {
            return "userIsNotFound";
        }
        if(pwd == null || !pwd.equals(user.getPwd())) {
            return "pwdError";
        }
        List<Role> roles = roleService.getRoleByUserId(userId);
        model.addAttribute("loginUser",user);
        userService.setLoginTime(userId);
        if(rememberPwd == 1) {
            Cookie cookie1 = new Cookie("userId",userId + "");
            Cookie cookie2 = new Cookie("pwd",pwd);
            cookie1.setMaxAge(1000 * 30);
            cookie2.setMaxAge(1000 * 30);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        }
        if(roles.size() == 1) {
            model.addAttribute("role",roles.get(0).getRoleId());
            return "index";
        } else if(roles.size() > 1){
            model.addAttribute("roles",roles);
            return "roleChoose";
        } else {
            return "noRole";
        }
    }

    @RequestMapping("roles")
    @ResponseBody
    public String getRole(String roleId,Model model) {
        if (!"0".equals(roleId)) {
            model.addAttribute("role",Integer.parseInt(roleId));
            return "index";
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public ListData getUserList(int limit, int page, String name, String deptId) {
        String username = name == null ? "" : name;
        int dpId = deptId == null ? 0 : Integer.parseInt(deptId);
        List<Map<String, Object>> userList = userService.getAllUserByPage(limit,page,username,dpId);
        int size = userService.getAllUsers(username,dpId).size();
        ListData userData = new ListData(size,userList);
        return userData;
    }

    @RequestMapping("/userList")
    public String userList(Model model) {
        model.addAttribute("deptList",deptService.getAllDept());
        return "user/userList";
    }

    @RequestMapping("/adduser")
    public String adduser(Model model) {
        model.addAttribute("deptList",deptService.getAllDept());
        return "user/adduser";
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(User user) {

        return userService.addUser(user);
    }


    @RequestMapping("/upduser")
    public String upduser(int userId, Model model) {
        model.addAttribute("upduser",userService.getUserByUserId(userId));
        model.addAttribute("deptList",deptService.getAllDept());
        return "user/upduser";
    }
    @RequestMapping("/updUser")
    @ResponseBody
    public boolean updUser(User user) {
        return userService.updUser(user);
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public boolean delUser(String userId) {
        if(userId == null) {
            return false;
        }
        return userService.delUserByUserId(Integer.parseInt(userId));
    }

    @RequestMapping("/delUsers")
    @ResponseBody
    public boolean delUsers(String userIds) {
        return userService.delUsersByUserId(userIds);
    }

    @RequestMapping("/getPwdList")
    @ResponseBody
    public ListData getPwdList(int limit, int page, String name, String roleId) {
        String username = name == null ? "" : name;
        int roId = roleId == null ? 0 : Integer.parseInt(roleId);
        List<Map<String, Object>> userList = userService.getAllUserByRole(limit,page,username,roId);
        int size = userService.getAllUsers(username,roId).size();
        ListData userData = new ListData(size,userList);
        return userData;
    }

    @RequestMapping("/pwdList")
    public String pwdList(Model model) {
        model.addAttribute("deptList",deptService.getAllDept());
        return "user/pwdList";
    }


    @RequestMapping("/updpwd")
    public String updpwd(int userId, Model model) {
        model.addAttribute("userId",userId);
        return "user/updpwd";
    }
    @RequestMapping("/updPwd")
    @ResponseBody
    public boolean updPwd(String userId,String pwd) {
        int id = userId == null ? 0:Integer.parseInt(userId);
        return userService.updPwd(id,pwd);
    }

    @RequestMapping("/edituser")
    public String updUser(int userId,Model model) {
        model.addAttribute("user",userService.getUserByUserId(userId));
        model.addAttribute("deptList",deptService.getAllDept());
        return "user/edituser";
    }
    @RequestMapping("/updUserByUser")
    @ResponseBody
    public boolean updUserByUser(User user){
        int deptId = user.getDeptId();
        if (deptId==0){
            return userService.updUserByUser(user);
        }else {
            return userService.updUser(user);
        }
    }



    @RequestMapping("/edituserpwd")
    public String edituserpwd(int userId,Model model) {
        model.addAttribute("user",userService.getUserByUserId(userId));
        return "user/edituserpwd";
    }
    @RequestMapping("/editPwd")
    @ResponseBody
    public boolean editPwd(String userId,String pwd) {
        int id = userId == null ? 0:Integer.parseInt(userId);
        return userService.updPwd(id,pwd);
    }


}
