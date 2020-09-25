package com.jxd.controller;

import com.jxd.model.ListData;
import com.jxd.model.Score;
import com.jxd.service.ICourseService;
import com.jxd.service.IScoreService;
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
 * @date 2020-09-23 19:50
 */
@Controller
public class ScoreController {
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private ICourseService courseService;

    @RequestMapping("/scoreList")
    public String scoreList() {
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
    public ListData getCourseList(int limit, int page, String name) {
        String scoreName = name ==null? "" : name;
        List<Map<String, Object>> scoreList = scoreService.getAllScoreByPage(limit,page,scoreName);
        int size = scoreList.size();
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
        model.addAttribute("stuList",scoreService.getStuName());
        model.addAttribute("courseList",courseService.getAllCourse());
        return "score/addscore";
    }
    @RequestMapping("/addScore")
    @ResponseBody
    public boolean addScore(Score score) {
        return scoreService.addScore(score);
    }

    @RequestMapping("/updscore")
    public String updscore(int stuId, Model model) {
        model.addAttribute("stuList",scoreService.getStuName());
        model.addAttribute("updscore",scoreService.getScoreByStuId(stuId));
        model.addAttribute("courseList",courseService.getAllCourse());
        return "score/updscore";
    }
    @RequestMapping("/updScore")
    @ResponseBody
    public boolean updScore(Score score) {
        return scoreService.updScore(score);
    }

    @RequestMapping("/delScore")
    @ResponseBody
    public boolean delScore(String stuId,String courseId) {
        if(stuId == null || courseId==null) {
            return false;
        }
        return scoreService.delScore(Integer.parseInt(stuId),Integer.parseInt(courseId));
    }

}
