package com.jxd.model;

/**
 * @author LuWenlong
 * @description 课程类
 * @date 2020-09-21 10:05
 */
public class Course {
    /**
     * 课程id
     */
    private int courseId;
    /**
     * 课程名
     */
    private String courseName;

    /**
     * 1/0选或者没有选
     * 1表示true
     * 0表示false
     */
    private int courseState;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseState() {
        return courseState;
    }

    public void setCourseState(int courseState) {
        this.courseState = courseState;
    }

    public Course(){

    }

    public Course(String courseName, int courseState) {
        this.courseName = courseName;
        this.courseState = courseState;
    }

    public Course(int courseId, String courseName, int courseState) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseState = courseState;
    }
}
