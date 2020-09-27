package com.jxd.controller;

import com.jxd.dao.IRoleDao;
import com.jxd.model.ListData;
import com.jxd.model.UserRoleRelationship;
import com.jxd.service.IRoleService;
import com.jxd.service.IUserRoleRelationshipService;
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
    private IUserRoleRelationshipService userRoleRelationshipService;

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
        model.addAttribute("userId",userId);
        model.addAttribute("roleList",roleService.getAllRole());
        return "role/addrole";
    }
    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(UserRoleRelationship us) {
        List<UserRoleRelationship> usList = userRoleRelationshipService.getAllUserRole();
        for(UserRoleRelationship user:usList){
            if ((int)user.getUserId() == (int)us.getUserId() && (int)user.getRoleId() == (int)us.getRoleId()){
                return "该用户已有此权限，授权失败";
            }
        }
       boolean flag = userRoleRelationshipService.addRole(us);
        if (flag){
            return "授权成功";
        }else {
            return "授权失败";
        }
    }
    @RequestMapping("/delRole")
    @ResponseBody
    public boolean delRole(UserRoleRelationship us){
        List<UserRoleRelationship> usList = userRoleRelationshipService.getAllUserRole();
        for(UserRoleRelationship user:usList){
            if ((int)user.getUserId() == (int)us.getUserId() && (int)user.getRoleId() == (int)us.getRoleId()){
              return userRoleRelationshipService.delRole(us.getUserId(),us.getRoleId());
            }
        }return false;
    }
}
