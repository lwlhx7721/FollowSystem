package com.jxd.dao;

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

}
