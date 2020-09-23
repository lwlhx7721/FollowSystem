package com.jxd.controller;

import com.jxd.model.ListData;
import com.jxd.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        List<Map<String, Object>> scoreList=scoreService.getAllScoreByPage(limit,page,scoreName);
        int size = scoreList.size();
        ListData scoreData = new ListData(size,scoreList);
        return scoreData;
    }
}
