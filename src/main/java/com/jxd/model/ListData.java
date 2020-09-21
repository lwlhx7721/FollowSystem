package com.jxd.model;

import java.util.List;

/**
 * @author LuWenlong
 * @description 用于返回前台数据的工具类，存储list数据集合和总数据条数
 * @date 2020-09-21 13:42
 */
public class ListData {
    /**
     * 数据集合条目数
     */
    private int count;
    /**
     * 数据集合
     */
    private List list;

    public ListData() {
    }

    public ListData(int count, List list) {
        this.count = count;
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
