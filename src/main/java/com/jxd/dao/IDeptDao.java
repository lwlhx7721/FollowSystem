package com.jxd.dao;

import com.jxd.model.Dept;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-23 01:34
 */
public interface IDeptDao {
    /**
     * 获取所有部门信息
     * @return
     */
    List<Dept> getAllDept();
}
