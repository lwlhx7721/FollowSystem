package com.jxd.service.impl;

import com.jxd.dao.IStudentDao;
import com.jxd.model.Student;
import com.jxd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 10:36
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    /**
     * 获取所有学员信息
     * @return 返回查询到的学员信息集合
     */
    @Override
    public List<Map<String, Object>> getAllStudent(String stuName, int classId, int deptId) {
        return studentDao.getAllStudent(stuName, classId, deptId);
    }

    @Override
    public List<Map<String, Object>> getAllStudentByPage(String stuName, int classId, int deptId, int pageIndex, int pageSize) {
        int PageIndex = (pageIndex - 1)*pageSize;
        return studentDao.getAllStudentByPage(stuName, classId, deptId, PageIndex, pageSize);
    }

    @Override
    public boolean addStudents(Student student) {
        return studentDao.addStudents(student);
    }

    @Override
    public Map<String, Object> getStudentById(int stuId) {
        return studentDao.getStudentById(stuId);
    }

    @Override
    public boolean updStudents(Student student) {
        return studentDao.updStudents(student);
    }

    @Override
    public boolean delStudentByStuId(int stuId) {
        return studentDao.delStudentByStuId(stuId);
    }

}
