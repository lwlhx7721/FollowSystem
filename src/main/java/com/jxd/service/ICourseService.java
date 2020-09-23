package com.jxd.service;

import com.jxd.model.Course;

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
}
