package com.jxd.service;

import com.jxd.model.Dept;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-23 01:33
 */
public interface IDeptService {
    /**
     * 获取所有部门信息
     * @return
     */
    List<Dept> getAllDept();
}
