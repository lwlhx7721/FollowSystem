package com.jxd.service;

import com.jxd.model.Course;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 10:42
 */
public interface ICourseService {
    /**
     * 添加课程信息
     * @param course 课程
     * @return 是否成功
     */
    boolean addCourse(Course course);

    /**
     * 遍历所有课程
     * @return 课程集合
     */
    List<Map<String,Object>> getAllCourseByPage(int pageSize, int pageIndex, String courseName);

    /**
     * 根据课程编号修改课程名或课程状态
     * @param course 课程
     * @return 是否成功
     */
    String updCourse(Course course);

    /**
     * 根据课程编号删除课程
     * @param courseId 课程编号
     * @return 是否成功
     */
    boolean delCourse(int courseId);

    /**
     *遍历所有的课程
     * @return 课程集合
     */
    Course getCourse(int courseId);
}
