package com.jxd.dao;

import com.jxd.model.Menu;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-22 10:12
 */
public interface IMenuDao {
    /**
     * 通过rolePower表获取（rolePower.roleId = menu.roleId）符合要求的menuId（多个）
     * 通过查询出的menuId获取所有的菜单信息
     * @param roleId
     * @return
     */
    List<Menu> getMenuByRoleId(int roleId);
}
