package com.jxd.model;

/**
 * @author ShiWenZhe
 * @description 成绩表
 * @date 2020-09-21 11:17
 */
public class Score {
    /**
     * 学生id
     */
    private int stuId;
    /**
     * 课程id
     */
    private int courseId;
    /**
     * 学生成绩
     */
    private int score;

    public Score() {
    }

    public Score(int stuId, int courseId, int score) {
        this.stuId = stuId;
        this.courseId = courseId;
        this.score = score;
    }

    public Score(int courseId, int score) {
        this.courseId = courseId;
        this.score = score;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
