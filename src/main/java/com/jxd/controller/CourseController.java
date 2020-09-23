package com.jxd.controller;

import com.jxd.model.Course;
import com.jxd.model.ListData;
import com.jxd.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 14:14
 */
@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;

    /**
     * 获取所有的课程信息
     * @param limit 分页
     * @param page 页码
     * @param name 课程名
     * @return 返回集合
     */
    @RequestMapping("/getCourseList")
    @ResponseBody
    public ListData getCourseList(int limit, int page, String name) {
        String courseName = name ==null? "" : name;
        List<Map<String, Object>> courseList=courseService.getAllCourseByPage(limit,page,courseName);
        int size = courseList.size();
        ListData courseData = new ListData(size,courseList);
        return courseData;
    }

    /**
     * 添加课程信息
     * @param course 课程
     * @return 是否成功
     */
    @RequestMapping("/addCourse")
    @ResponseBody
    public boolean addCourse(Course course){
        return courseService.addCourse(course);
    }

    /**
     * 根据课程编号删除课程
     * @param course 课程
     * @return 是否成功
     */
    @RequestMapping(value = "delCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delCourse(Course course){
        int a = course.getCourseState();
        if (course.getCourseState()==1){
         return "该课程已选，无法删除";
        }else {
            boolean flag = courseService.delCourse(course.getCourseId());
            if (flag){
                return "删除成功";
            }else {
                return "删除失败";
            }
        }
    }

    @RequestMapping("/updcourse")
    public String updCourse(int courseId,Model model){
        model.addAttribute("course",courseService.getCourse(courseId));
        return "course/updcourse";
    }

    @RequestMapping("/updCourse")
    @ResponseBody
    public boolean updCourse(Course course) {
        if (course.getCourseName()==null){
            return false;
        }
        return courseService.updCourse(course);
    }
}
