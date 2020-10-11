package com.jxd.service.impl;

import com.jxd.dao.IJobEvaluationDao;
import com.jxd.dao.ISchoolEvaluationDao;
import com.jxd.dao.IScoreDao;
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
    @Autowired
    private IScoreDao scoreDao;
    @Autowired
    private ISchoolEvaluationDao schoolEvaluationDao;
    @Autowired
    private IJobEvaluationDao jobEvaluationDao;

    /**
     * 获取数据库里的学生数
     * @return 返回一个学生集合
     */
    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    /**
     * 获取所有学员信息
     * @return 返回查询到的学员信息集合
     */
    @Override
    public List<Map<String, Object>> getAllStudent(String stuName, int classId, int deptId) {
        return studentDao.getAllStudent(stuName, classId, deptId);
    }

    /**
     * 分页查询学员信息
     * @return 返回查询到的学员信息集合
     */
    @Override
    public List<Map<String, Object>> getAllStudentByPage(String stuName, int classId, int deptId, int pageIndex, int pageSize) {
        int PageIndex = (pageIndex - 1)*pageSize;
        return studentDao.getAllStudentByPage(stuName, classId, deptId, PageIndex, pageSize);
    }

    /**
     * 新增学员信息
     * @param student 接收一个学员对象，里面封装了学员的信息
     * @return 返回是否新增成功
     */
    @Override
    public boolean addStudents(Student student) {
        return studentDao.addStudents(student);
    }

    /**
     * 根据id查看该学员信息
     * @param stuId 学员id
     * @return 返回学员对象
     */
    @Override
    public Map<String, Object> getStudentById(int stuId) {
        return studentDao.getStudentById(stuId);
    }

    /**
     * 修改学员信息
     * @param student 接收学员对象
     * @return
     */
    @Override
    public boolean updStudents(Student student) {
        return studentDao.updStudents(student);
    }

    /**
     * 根据id删除学员
     * @param stuId 学员id
     * @return 返回是否成功
     */
    @Override
    public boolean delStudentByStuId(int stuId) {
        scoreDao.delScore(stuId);
        schoolEvaluationDao.delSchoolEvaluationByStuId(stuId);
        jobEvaluationDao.delJobEvaluationByStuId(stuId);
        return studentDao.delStudentByStuId(stuId);
    }

    /**
     * 批量删除学员信息
     * @param stuIds 接收id数组
     * @return 返回是否成功
     */
    @Override
    public boolean delStudentsById(String stuIds) {
        scoreDao.delScores(stuIds);
        schoolEvaluationDao.delSchoolEvaluationsByStuId(stuIds);
        jobEvaluationDao.delJobEvaluationsByStuId(stuIds);
        return studentDao.delStudentsById(stuIds);
    }

}
