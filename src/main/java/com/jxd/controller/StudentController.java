package com.jxd.controller;

import com.jxd.model.ListData;
import com.jxd.service.ICityService;
import com.jxd.service.IClassService;
import com.jxd.service.IDeptService;
import com.jxd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 10:34
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private IClassService classService;
    @Autowired
    private ICityService cityService;

    @RequestMapping("/getStudentList")
    @ResponseBody
    public ListData getStudentList(String name, String classId, String deptId,String limit, String page) {
        String stuName = name == null ? "" : name;
        int cId = classId == null ? 0 : Integer.parseInt(classId);
        int limit1 = limit == null ? 0 : Integer.parseInt(limit);
        int page1 = page == null ? 0 : Integer.parseInt(page);
        System.out.println(limit);
        int dId = deptId == null ? 0 : Integer.parseInt(deptId);
        System.out.println(1);
        List<Map<String, Object>> studentList = studentService.getAllStudentByPage(stuName, cId, dId, page1, limit1);
        System.out.println(2);
        int size = studentService.getAllStudent(stuName, cId, dId).size();
        System.out.println(3);
        ListData studentData = new ListData(size,studentList);
        return studentData;
    }

    @RequestMapping("/stuList")
    public String getDeptAndClassList(Model model) {
        model.addAttribute("deptList",deptService.getAllDept());
        model.addAttribute("classList",classService.getAllClass());
        return "student/studentList";
    }

    @RequestMapping("/cityList")
    public String cityList(int parentId, int type, Model model) {
        model.addAttribute("classList",classService.getAllClass());
        List<Map<String, Object>> cityList = cityService.getCity(parentId);
        if (type == 1) {
            model.addAttribute("city1List", cityList);
            System.out.println(cityList.size());
        } else if(type == 2) {
            model.addAttribute("city2List", cityList);
            System.out.println(cityList);
        } else if (type == 3) {
            model.addAttribute("city3List", cityList);
            System.out.println(cityList );
        }
        return "student/addStudent";
    }
}
