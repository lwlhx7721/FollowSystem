package com.jxd.service.impl;

import com.jxd.dao.ICourseDao;
import com.jxd.model.Course;
import com.jxd.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    /**
     * 遍历所有课程
     * @return 课程集合
     */
    @Override
    public List<Map<String, Object>> getAllCourseByPage(int pageSize, int pageIndex, String courseName) {
        return courseDao.getAllCourseByPage(pageSize,pageIndex,courseName);
    }


    /**
     * 根据课程编号修改课程名或课程状态
     * @param course 课程
     * @return 是否成功
     */
    @Override
    public String updCourse(Course course) {
        return courseDao.updCourse(course);
    }
    /**
     * 根据课程编号删除课程
     * @param courseId 课程编号
     * @return 是否成功
     */
    @Override
    public boolean delCourse(int courseId) {
        return courseDao.delCourse(courseId);
    }
    /**
     *遍历所有的课程
     * @return 课程集合
     */
    @Override
    public Course getCourse(int courseId) {
        return courseDao.getCourse(courseId);
    }
}
