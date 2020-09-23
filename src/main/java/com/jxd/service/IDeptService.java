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
     * @return 部门信息
     */
    List<Dept> getAllDept();

    /**
     * 添加部门信息
     * @param dept 新增部门对象
     * @return 是否新增成功的标志
     */
    boolean addDept(Dept dept);

    /**
     * 修改部门信息
     * @param dept 修改部门对象
     * @return 是否修改成功的标志
     */
    boolean updateDept(Dept dept);

    /**
     * 删除部门信息
     * @param deptid 部门编号
     * @return 是否删除成功的标志
     */
    boolean delDept(int deptid);
}
