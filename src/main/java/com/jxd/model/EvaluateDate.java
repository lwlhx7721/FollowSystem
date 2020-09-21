package com.jxd.model;

/**
 * @author LuWenlong
 * @description 工作时间
 * @date 2020-09-21 10:07
 */
public class EvaluateDate {
    /**
     * 日期类编号
     */
    private int dateId;
    /**
     * 工作状态名
     */
    private String dateName;

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }
    public EvaluateDate(){

    }

    public EvaluateDate(String dateName) {
        this.dateName = dateName;
    }

    public EvaluateDate(int dateId, String dateName) {
        this.dateId = dateId;
        this.dateName = dateName;
    }
}
