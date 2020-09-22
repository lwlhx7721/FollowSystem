package com.jxd.controller;

import com.jxd.model.Menu;
import com.jxd.model.Role;
import com.jxd.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-22 10:19
 */
@Controller
public class MenuController {
    @Autowired
    private IMenuService menuService;
    /**
     * 获取角色权限菜单
     * 跳转到index.jsp页面
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        int roleId = (int)request.getSession().getAttribute("role");
        List<Menu> menus = menuService.getMenuByRoleId(roleId);
        model.addAttribute("menus",menus);
        return "index";
    }
}
