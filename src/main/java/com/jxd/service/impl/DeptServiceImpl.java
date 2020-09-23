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
     * @param deptid 部门编号
     * @return 是否删除成功的标志
     */
    @Override
    public boolean delDept(int deptid) {
        return deptDao.delDept(deptid);
    }
}
