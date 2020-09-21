package com.jxd.model;

/**
 * @author LuWenlong
 * @description 班级类
 * @date 2020-09-21 10:04 b                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    vb
 */
public class Class {
    /**
     * 班级id
     */
    private int classId;
    /**
     * 班级名称
     */
    private String className;

    public Class(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Class(String className) {
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
