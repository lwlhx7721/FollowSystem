package com.jxd.service.impl;

import com.jxd.dao.IMenuDao;
import com.jxd.model.Menu;
import com.jxd.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-22 10:21
 */
@Service
public class MenuService implements IMenuService {
    @Autowired
    private IMenuDao menuDao;

    /**
     * 通过rolePower表获取（rolePower.roleId = roeId）符合要求的menuId（多个）
     * 通过查询出的menuId获取所有的菜单信息
     * @param roleId 角色ID
     * @return 菜单信息列表
     */
    @Override
    public List<Menu> getMenuByRoleId(int roleId) {
        return menuDao.getMenuByRoleId(roleId);
    }
}
