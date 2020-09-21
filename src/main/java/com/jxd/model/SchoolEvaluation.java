package com.jxd.model;

/**
 * @author LuWenlong
 * @description 培训学校评价
 * @date 2020-09-21 11:16
 */
public class SchoolEvaluation {
    /**
     * 评价ID
     */
    private int evaluateId;
    /**
     * 学生ID
     */
    private int stuId;
    /**
     * 评价人
     */
    private int evaluatePerson;
    /**
     * 评价成绩
     */
    private String evaluateScore;
    /**
     * 综合评语
     */
    private String evaluateContent;

    public SchoolEvaluation(int evaluateId, int stuId, int evaluatePerson, String evaluateScore, String evaluateContent) {
        this.evaluateId = evaluateId;
        this.stuId = stuId;
        this.evaluatePerson = evaluatePerson;
        this.evaluateScore = evaluateScore;
        this.evaluateContent = evaluateContent;
    }

    public SchoolEvaluation(int stuId, int evaluatePerson, String evaluateScore, String evaluateContent) {
        this.stuId = stuId;
        this.evaluatePerson = evaluatePerson;
        this.evaluateScore = evaluateScore;
        this.evaluateContent = evaluateContent;
    }

    public SchoolEvaluation() {
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getEvaluatePerson() {
        return evaluatePerson;
    }

    public void setEvaluatePerson(int evaluatePerson) {
        this.evaluatePerson = evaluatePerson;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }
}
