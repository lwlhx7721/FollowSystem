package com.jxd.model;

/**
 * @author LuWenlong
 * @description 班级类
 * @date 2020-09-21 10:04
 */
public class Class {
    private int classId;
    private String className;

    public Class(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Class() {
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
