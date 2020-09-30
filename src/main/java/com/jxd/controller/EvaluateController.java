package com.jxd.controller;

import com.jxd.model.ListData;
import com.jxd.service.ICourseService;
import com.jxd.service.IEvaluateDateService;
import com.jxd.service.IEvaluateService;
import com.jxd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description 评论页面
 * @date 2020-09-27 17:18
 */
@Controller
public class EvaluateController {
    @Autowired
    private IEvaluateService evaluateService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IEvaluateDateService evaluateDateService;

    @RequestMapping("/stuList")
    public String stuList(Model model) {
        model.addAttribute("courseList",courseService.getAllCourseByState());
        model.addAttribute("evaluateDateList",evaluateDateService.getAllEvaluate());
        return "evaluate/stuList";
    }

    @RequestMapping("/eva")
    public String eva(String stuId,Model model) {
        int id = stuId == null ? 0:Integer.parseInt(stuId);
        model.addAttribute("courseList",courseService.getAllCourseByState());
        model.addAttribute("evaluateDateList",evaluateDateService.getAllEvaluate());
        Map<String, Object> student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        Map<String, Object> stuSchoolEva = evaluateService.getStuByStuId(id);
        model.addAttribute("stuSchoolEva", stuSchoolEva);
        return "evaluate/eva";
    }

    @RequestMapping("/evaList")
    @ResponseBody
    public Object evaList(String limit, String page) {
        int pageSize = limit == null ? 0 : Integer.parseInt(limit);
        int pageIndex = page == null ? 0 : Integer.parseInt(page);
        List<Map<String, Object>> evaList = evaluateService.getAllStuListByPage(pageIndex,pageSize);
        int size = evaluateService.getAllStuList().size();
        ListData studentData = new ListData(size,evaList);
        return studentData;
    }
}
