package com.jxd.controller;

import com.jxd.dao.IStudentDao;
import com.jxd.model.Course;
import com.jxd.model.ListData;
import com.jxd.model.Score;
import com.jxd.service.IClassService;
import com.jxd.service.ICourseService;
import com.jxd.service.IScoreService;
import com.jxd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 19:50
 */
@Controller
public class ScoreController {
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

    @RequestMapping("/scoreList")
    public String
    scoreList(Model model) {
        List<Course> courseList = courseService.getAllCourseByState();
        model.addAttribute("courseList", courseList);
        model.addAttribute("classList",classService.getAllClass());
        return "score/scoreList";
    }
    /**
     * 获取所有的课程信息
     * @param limit 分页
     * @param page 页码
     * @param name 课程名
     * @return 返回集合
     */
    @RequestMapping("/getScoreList")
    @ResponseBody
    public ListData getCourseList(int limit, int page, String name,String classId) {
        int cId = classId == null ? 0:Integer.parseInt(classId);
        String scoreName = name == null? "" : name;
        List<Map<String, Object>> scoreList = scoreService.getAllScoreByPage(limit,page,scoreName,courseService.getAllCourseByState(), cId);
        int size = studentService.getAllStudents().size();
        ListData scoreData = new ListData(size,scoreList);
        return scoreData;
    }

    /**
     * 添加学生成绩
     * @param model
     * @return
     */
    @RequestMapping("/addscore")
    public String addscore(Model model) {
        model.addAttribute("classList",classService.getAllClass());
        model.addAttribute("courseList",courseService.getAllCourseByState());
        return "score/addscore";
    }

    @RequestMapping(value="/getStu",method = RequestMethod.POST )
    @ResponseBody
    public List<Map<String, Object>> getStuByClass(String classId) {
        int id = classId == null ? 0:Integer.parseInt(classId);
        List<Map<String, Object>> stuList = scoreService.getStuNameByClass(id);
        return stuList;
    }

    @RequestMapping("/addScore")
    @ResponseBody
    public boolean addScore(HttpServletRequest request,String stu) {
        String[] scores = request.getParameterValues("score");
        System.out.println(stu);
        int id = stu == null ? 0 : Integer.parseInt(stu);
        int[] sc = new int[scores.length];
        for (int i = 0;i < scores.length;i++) {
            sc[i] = scores[i] == null ? -1 : Integer.parseInt(scores[i]);
        }
        List<Course> courseList = courseService.getAllCourseByState();
        List<Score> scoreList = new ArrayList<>();
        for (int i = 0;i < courseList.size();i++) {
            scoreList.add(new Score(courseList.get(i).getCourseId(),sc[i]));
        }
        return scoreService.addScore(id, scoreList);
    }

    @RequestMapping("/updscore")
    public String updscore(String stuId,String courseId, Model model) {
        int id = stuId == null? 0:Integer.parseInt(stuId);
        int cId = courseId == null ? 0:Integer.parseInt(courseId);
        Map<String, Object> scoreMap = scoreService.getScoreByStuId(id,cId);
        model.addAttribute("scoreMap",scoreMap);
        return "score/updscore";
    }
    @RequestMapping("/updScore")
    @ResponseBody
    public boolean updScore(Score score) {
        return scoreService.updScore(score);
    }

    @RequestMapping(value = "/delScore",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delScore(String stuId,String courseId) {
        int sId = stuId == null ? 0:Integer.parseInt(stuId);
        int cId = courseId == null ? 0:Integer.parseInt(courseId);
        if(scoreService.delScore(sId, cId)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
