package com.jxd.model;

/**
 * @author LuWenlong
 * @description 部门类
 * @date 2020-09-21 10:06
 */
public class Dept {
    /**
     * 部门id
     */
    private int deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门地址
     */
    private String deptAddress;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }
    public Dept(){

    }

    public Dept(String deptName, String deptAddress) {
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }

    public Dept(int deptId, String deptName, String deptAddress) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }
}
