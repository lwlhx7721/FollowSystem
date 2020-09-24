package com.jxd.service.impl;

import com.jxd.dao.IDeptDao;
import com.jxd.model.Dept;
import com.jxd.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-23 08:40
 */

@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDao deptDao;

    /**
     * 获取所有部门信息
     * @return 部门信息列表
     */
    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    /**
     * 通过部门名称进行模糊查询
     * @param deptName 部门名称
     * @return 部门信息
     */
    @Override
    public List<Dept> getAllDeptByDeptname(String deptName) {
        System.out.println(deptDao);
        return deptDao.getAllDeptByDeptname(deptName);
    }
    /**
     * 通过部门名称分页查询
     * @param limit 每页的条数
     * @param page 页数
     * @param deptName 部门名称
     * @return 部门信息
     */
    @Override
    public List<Dept> getAllDeptByPage(int limit, int page, String deptName) {
        return deptDao.getAllDeptByPage(limit, page, deptName);
    }

    /**
     * 通过部门ID获取部门信息
     * @param deptId
     * @return
     */
    @Override
    public Dept getDeptByDeptId(int deptId) {
        return deptDao.getDeptByDeptId(deptId);
    }

    /**
     * 添加部门信息
     * @param dept 新增部门对象
     * @return 是否新增成功的标志
     */
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    /**
     * 修改部门信息
     * @param dept 修改部门对象
     * @return 是否修改成功的标志
     */
    @Override
    public boolean updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    /**
     * 删除部门信息
     * @param deptId 部门编号
     * @return 是否删除成功的标志
     */
    @Override
    public boolean delDeptByDeptid(int deptId) {
        return deptDao.delDeptByDeptid(deptId);
    }

    /**
     * 批量删除部门信息
     * @param deptIds 部门编号
     * @return 是否删除成功标志
     */
    @Override
    public boolean delDeptsByDeptids(String deptIds) {
        return deptDao.delDeptsByDeptids(deptIds);
    }

}
