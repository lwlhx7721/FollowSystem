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

    @RequestMapping("courseList")
    public String courseList() {
        return "course/courseList";
    }
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
        int size = courseService.getAllCourse().size();
        ListData courseData = new ListData(size,courseList);
        return courseData;
    }

    /**
     * 添加课程信息
     * @param
     * @return 是否成功
     */
    @RequestMapping(value="/addcourse",produces = "text/html;charset=utf-8")
    public String addCourse(){
        return "course/addcourse";
    }
    @RequestMapping("/addCourse")
    @ResponseBody
    public String addCourse(Course course){
        List<Course> list = courseService.getAllCourse();
        String isAdd = null;
        for(Course course1 : list){
            if (course1.getCourseName().equals(course.getCourseName())){
                isAdd = "已有相同课程";
                return isAdd;
            }
        }
            courseService.addCourse(course);
            isAdd ="新增成功";
            return isAdd;
    }

    /**
     * 根据课程编号启用/停用课程
     * @param courseState 课程状态
     * @return 是否成功
     */
    @RequestMapping(value = "delCourse",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delCourse(int courseState, int courseId) {
        System.out.println(courseId + courseState);
        if(courseState == 1 ) {
            courseService.delCourse(courseId, 0);
            return "操作成功";
        } else if(courseState == 0 ) {
            courseService.delCourse(courseId, 1);
            return "操作成功";
        } else {
            return "操作失败";
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
        return courseService.updCourse(course);
    }
}
