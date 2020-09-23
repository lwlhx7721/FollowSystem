package com.jxd.dao;

import com.jxd.model.Course;

import java.util.List;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 10:41
 */
public interface ICourseDao {
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
    List<Course> getAllCourse();

    /**
     * 根据课程编号修改课程名或课程状态
     * @param courseId 课程编号
     * @return 是否成功
     */
    boolean updCourse(int courseId);

    /**
     * 根据课程编号删除课程
     * @param courseId 课程编号
     * @return 是否成功
     */
    boolean delCourse(int courseId);
}
