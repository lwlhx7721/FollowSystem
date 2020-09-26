package com.jxd.service;

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
}
