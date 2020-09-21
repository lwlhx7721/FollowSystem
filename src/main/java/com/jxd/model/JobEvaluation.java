package com.jxd.model;

/**
 * @author LuWenlong
 * @description 工作评价
 * @date 2020-09-21 10:57
 */
public class JobEvaluation {
    /**
     * 日期ID
     */
    private int dateId;
    /**
     * 学生Id
     */
    private int stuId;
    /**
     * 选项id
     */
    private int optionId;
    /**
     * 评价人
     */
    private int evaluatePerson;
    /**
     * 评分
     */
    private int evaluateScore;
    /**
     * 总成绩
     */
    private int totalScore;
    /**
     * 工作评估内容
     */
    private String jobEvaluateContent;

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getEvaluatePerson() {
        return evaluatePerson;
    }

    public void setEvaluatePerson(int evaluatePerson) {
        this.evaluatePerson = evaluatePerson;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getJobEvaluateContent() {
        return jobEvaluateContent;
    }

    public void setJobEvaluateContent(String jobEvaluateContent) {
        this.jobEvaluateContent = jobEvaluateContent;
    }
    public JobEvaluation(){

    }

    public JobEvaluation(int stuId, int optionId, int evaluatePerson, int evaluateScore, int totalScore, String jobEvaluateContent) {
        this.stuId = stuId;
        this.optionId = optionId;
        this.evaluatePerson = evaluatePerson;
        this.evaluateScore = evaluateScore;
        this.totalScore = totalScore;
        this.jobEvaluateContent = jobEvaluateContent;
    }

    public JobEvaluation(int dateId, int stuId, int optionId, int evaluatePerson, int evaluateScore, int totalScore, String jobEvaluateContent) {
        this.dateId = dateId;
        this.stuId = stuId;
        this.optionId = optionId;
        this.evaluatePerson = evaluatePerson;
        this.evaluateScore = evaluateScore;
        this.totalScore = totalScore;
        this.jobEvaluateContent = jobEvaluateContent;
    }
}
