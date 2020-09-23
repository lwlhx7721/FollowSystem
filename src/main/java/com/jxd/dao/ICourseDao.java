package com.jxd.dao;

import com.jxd.model.Course;

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
}
