package com.jxd.service;

import com.jxd.model.City;
import com.jxd.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 10:35
 */
public interface IStudentService {
    /**
     * 获取所有学员信息
     * @return 返回查询到的学员信息集合
     */
    List<Map<String, Object>> getAllStudent(String stuName, int classId, int deptId);

    /**
     * 分页查询学员信息
     * @return 返回查询到的学员信息集合
     */
    List<Map<String, Object>> getAllStudentByPage(String stuName, int classId, int deptId, int pageIndex, int pageSize);

    /**
     * 新增学员信息
     * @param student 接收一个学员对象，里面封装了学员的信息
     * @return 返回是否新增成功
     */
    boolean addStudents(Student student);

    /**
     * 根据id查看该学员信息
     * @param stuId 学员id
     * @return 返回学员对象
     */
    Map<String, Object> getStudentById(int stuId);

    /**
     * 修改学员信息
     * @param student 接收学员对象
     * @return
     */
    boolean updStudents(Student student);

    /**
     * 根据id删除学员
     * @param stuId 学员id
     * @return 返回是否成功
     */
    boolean delStudentByStuId(int stuId);

    /**
     * 批量删除学员信息
     * @param stuIds 接收id数组
     * @return 返回是否成功
     */
    boolean delStudentsById(String stuIds);
}
