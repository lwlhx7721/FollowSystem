package com.jxd.model;

/**
 * @author LuWenlong
 * @description 评价分项
 * @date 2020-09-21 10:09
 */
public class JobEvaluateOption {
    /**
     * 选项id
     */
    private int optionId;
    /**
     * 选项名称
     */
    private String optionName;
    /**
     * 选项状态
     * 1表示true
     * 0表示false
     */
    private int optionState;

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionState() {
        return optionState;
    }

    public void setOptionState(int optionState) {
        this.optionState = optionState;
    }

    public JobEvaluateOption() {

    }

    public JobEvaluateOption(String optionName, int optionState) {
        this.optionName = optionName;
        this.optionState = optionState;
    }

    public JobEvaluateOption(int optionId, String optionName, int optionState) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionState = optionState;
    }
}
