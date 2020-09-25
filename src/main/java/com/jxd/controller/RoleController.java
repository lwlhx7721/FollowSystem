package com.jxd.controller;

import com.jxd.dao.IRoleDao;
import com.jxd.dao.IUserRoleRelationshipDao;
import com.jxd.model.ListData;
import com.jxd.model.Role;
import com.jxd.model.UserRoleRelationship;
import com.jxd.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-25 14:55
 */
@Controller
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleRelationshipDao userRoleRelationshipDao;

    @RequestMapping("/getRoleList")
    @ResponseBody
    public ListData getRoleList(int limit, int page, String name) {
        String username = name == null ? "" : name;
        List<Map<String, Object>> roleList = roleService.getUserAndRole(limit,page,username);
        int size = roleList.size();
        ListData roleData = new ListData(size,roleList);
        return roleData;
    }

    @RequestMapping("/addrole")
    public String addrole(int userId,Model model) {
        model.addAttribute("roleList",roleService.getAllRole());
        return "role/addrole";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(int userId,Role role) {
        List<UserRoleRelationship> usList = userRoleRelationshipDao.getAllUserRole();
        for (UserRoleRelationship ur : usList){
            if (ur.getUserId()==userId && ur.getRoleId()==role.getRoleId()){
                return "已授予用户该权限";
            }
        }
        boolean flag = userRoleRelationshipDao.addRole(userId,role.getRoleId());
        if (flag){
            return "授权成功";
        }else {
            return "授权失败";
        }
    }
    @RequestMapping("/delRole")
    @ResponseBody
    public boolean delRole(int userId,int roleId){
        List<UserRoleRelationship> usList = userRoleRelationshipDao.getAllUserRole();
        for (UserRoleRelationship ur : usList){
            if (ur.getRoleId()== userId && ur.getUserId()==roleId ){
                return userRoleRelationshipDao.delRole(userId, roleId);
            }
        }
        return false;
    }
}
