package com.jxd.dao;

import com.jxd.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 10:36
 */
public interface IStudentDao {
    /**
     * 获取所有学员信息
     * @return 返回查询到的学员信息集合
     */
    List<Map<String, Object>> getAllStudent(@Param("stuName") String stuName, @Param("classId") int classId, @Param("deptId") int deptId);

    /**
     * 分页查询学员信息
     * @return 返回查询到的学员信息集合
     */
    List<Map<String, Object>> getAllStudentByPage(@Param("stuName") String stuName, @Param("classId") int classId, @Param("deptId") int deptId, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

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
     * @return 返回是否成功
     */
    boolean updStudents(Student student);

    /**
     * 根据id删除学员
     * @param stuId 学员id
     * @return 返回是否成功
     */
    boolean delStudentByStuId(int stuId);
}
