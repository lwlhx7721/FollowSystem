package com.jxd.model;

/**
 * @author ShiWenZhe
 * @description 用户表
 * @date 2020-09-21 11:17
 */
public class User {
    /**
     * 用户id
     */
    private int userId;
    /**
     *用户名
     */
    private String userName;
    /**
     *密码
     */
    private String pwd;
    /**
     *用户座机号
     */
    private String telephone;
    /**
     *用户手机号
     */
    private int phone;
    /**
     *邮箱
     */
    private String email;
    /**
     *备注
     */
    private String note;
    /**
     *用户当前状态
     */
    private String flag;
    /**
     *登录时间
     */
    private String loginTime;
    /**
     *部门id
     */
    private int deptId;

    public User() {
    }

    public User(int userId, String userName, String pwd, String telephone, int phone, String email, String note, String flag, String loginTime, int deptId) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.phone = phone;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.loginTime = loginTime;
        this.deptId = deptId;
    }

    public User(String userName, String pwd, String telephone, int phone, String email, String note, String flag, String loginTime, int deptId) {
        this.userName = userName;
        this.pwd = pwd;
        this.telephone = telephone;
        this.phone = phone;
        this.email = email;
        this.note = note;
        this.flag = flag;
        this.loginTime = loginTime;
        this.deptId = deptId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
