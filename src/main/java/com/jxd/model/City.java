package com.jxd.model;

/**
 * @author ShiWenZhe
 * @description 新增学生时出生地的级联框
 * @date 2020-09-23 17:36
 */
public class City {
    /**
     * 城市id
     */
    private int id;
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 父级城市id
     */
    private int pid;
    /**
     * 城市类型(省、市、县)
     */
    private int type;

    public City() {
    }

    public City(int id, String cityName, int pid, int type) {
        this.id = id;
        this.cityName = cityName;
        this.pid = pid;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
