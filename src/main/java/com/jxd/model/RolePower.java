package com.jxd.model;

/**
 * @author LuWenlong
 * @description 权限菜单关联
 * @date 2020-09-21 11:15
 */
public class RolePower {
    /**
     * 角色ID
     */
    private int roleId;
    /**
     * 菜单ID
     */
    private int menuId;

    public RolePower(int roleId, int menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public RolePower(int menuId) {
        this.menuId = menuId;
    }

    public RolePower() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
}
