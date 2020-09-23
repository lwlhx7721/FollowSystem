package com.jxd.service.impl;

import com.jxd.dao.ICourseDao;
import com.jxd.model.Course;
import com.jxd.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 10:42
 */
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseDao courseDao;
    /**
     * 添加课程信息
     * @param course 课程
     * @return 是否成功
     */
    @Override
    public boolean addCourse(Course course) {
        return courseDao.addCourse(course);
    }
}
