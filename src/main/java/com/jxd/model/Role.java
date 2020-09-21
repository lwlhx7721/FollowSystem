package com.jxd.model;

/**
 * @author LuWenlong
 * @description 权限
 * @date 2020-09-21 10:58
 */
public class Role {
    /**
     * 角色ID
     */
    private int roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色类型
     */
    private int roleType;
    /**
     * 备注
     */
    private String note;
    /**
     * 标识
     */
    private int flag;
    /**
     * 用户角色类型
     */
    private String roleUserType;

    public Role(int roleId, String roleName, int roleType, String note, int flag, String roleUserType) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleType = roleType;
        this.note = note;
        this.flag = flag;
        this.roleUserType = roleUserType;
    }

    public Role(String roleName, int roleType, String note, int flag, String roleUserType) {
        this.roleName = roleName;
        this.roleType = roleType;
        this.note = note;
        this.flag = flag;
        this.roleUserType = roleUserType;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getRoleUserType() {
        return roleUserType;
    }

    public void setRoleUserType(String roleUserType) {
        this.roleUserType = roleUserType;
    }
}
