package com.jxd.controller;

import com.jxd.dao.IRoleDao;
import com.jxd.model.ListData;
import com.jxd.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/getRoleList")
    @ResponseBody
    public ListData getRoleList(int limit, int page, String name) {
        String username = name == null ? "" : name;
        List<Map<String, Object>> roleList = roleService.getUserAndRole(limit,page,username);
        int size = roleList.size();
        ListData roleData = new ListData(size,roleList);
        return roleData;
    }
}
