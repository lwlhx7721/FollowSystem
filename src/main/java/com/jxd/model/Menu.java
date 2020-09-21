package com.jxd.model;

/**
 * @author LuWenlong
 * @description 菜单
 * @date 2020-09-21 10:58
 */
public class Menu {
    /**
     * 菜单id
     */
    private int menuId;
    /**
     * 父级菜单
     */
    private int parentMenuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单路径
     */
    private String address;
    /**
     * 提示名称
     */
    private String promptName;
    /**
     * 目标
     */
    private String goal;
    /**
     * 图片
     */
    private String image;
    /**
     * 图片显示
     */
    private String imageShow;
    /**
     * 菜单显示
     */
    private String menuShow;
    private String expressShun;
    /**
     * 删除标志
     */
    private String deleteFlag;

    public Menu(int menuId, int parentMenuId, String menuName, String address, String promptName, String goal, String image, String imageShow, String menuShow, String expressShun, String deleteFlag) {
        this.menuId = menuId;
        this.parentMenuId = parentMenuId;
        this.menuName = menuName;
        this.address = address;
        this.promptName = promptName;
        this.goal = goal;
        this.image = image;
        this.imageShow = imageShow;
        this.menuShow = menuShow;
        this.expressShun = expressShun;
        this.deleteFlag = deleteFlag;
    }

    public Menu(int parentMenuId, String menuName, String address, String promptName, String goal, String image, String imageShow, String menuShow, String expressShun, String deleteFlag) {
        this.parentMenuId = parentMenuId;
        this.menuName = menuName;
        this.address = address;
        this.promptName = promptName;
        this.goal = goal;
        this.image = image;
        this.imageShow = imageShow;
        this.menuShow = menuShow;
        this.expressShun = expressShun;
        this.deleteFlag = deleteFlag;
    }

    public Menu() {
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(int parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromptName() {
        return promptName;
    }

    public void setPromptName(String promptName) {
        this.promptName = promptName;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageShow() {
        return imageShow;
    }

    public void setImageShow(String imageShow) {
        this.imageShow = imageShow;
    }

    public String getMenuShow() {
        return menuShow;
    }

    public void setMenuShow(String menuShow) {
        this.menuShow = menuShow;
    }

    public String getExpressShun() {
        return expressShun;
    }

    public void setExpressShun(String expressShun) {
        this.expressShun = expressShun;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
