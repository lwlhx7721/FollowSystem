package com.jxd.dao;

import com.jxd.model.Dept;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过部门名称进行模糊查询
     * @param deptName 部门名称
     * @return 部门信息
     */
    List<Dept> getAllDeptByDeptname(String deptName);

    /**
     * 通过部门名称分页查询
     * @param limit 每页的条数
     * @param page 页数
     * @param deptName 部门名称
     * @return 部门信息
     */
    List<Dept> getAllDeptByPage(@Param("limit") int limit,@Param("page") int page,@Param("deptName") String deptName);

    /**
     * 通过部门ID获取部门信息
     * @param deptId
     * @return
     */
    Dept getDeptByDeptId(int deptId);

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
     * @param deptId 部门编号
     * @return 是否删除成功的标志
     */
    boolean delDeptByDeptid(int deptId);

    /**
     * 批量删除部门信息
     * @param deptIds 部门编号
     * @return 是否删除成功标志
     */
    boolean delDeptsByDeptids(String deptIds);

}
