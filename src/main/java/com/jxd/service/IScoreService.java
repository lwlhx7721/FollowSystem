package com.jxd.service;

import com.jxd.model.Course;
import com.jxd.model.Score;
import com.jxd.model.Student;
import com.jxd.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 19:22
 */
public interface IScoreService {
    /**
     * 遍历所有课程
     * @return 课程集合
     */
    List<Map<String,Object>> getAllScoreByPage(int pageSize, int pageIndex, String stuName, List<Course> courseList, int classId);
    /**
     * 获取学生姓名
     * @return 结果集
     */
    List<Map<String, Object>> getStuNameByClass(int classId);
    /**
     * 遍历数据
     * @return 结果集
     */
    List<Score> getAllScore();

    /**
     * 添加学成绩
     * @param stuId 学员id
     * @param scoreList 成绩集合
     * @return 返回是否成功
     */
    boolean addScore(int stuId, List<Score> scoreList);

    /**
     * 根据学生id获取成绩信息
     * @param stuId 学生id
     * @return 成绩信息
     */
    List<Map<String, Object>> getScoreByStuId(int stuId);
    /**
     * 修改学生成绩
     * @param score 学生成绩
     * @return 是否成功
     */
    boolean updScore(Score score);

    /**
     * 根据学生编号以及课程编号删除成绩
     * @param stuId 学生编号
     * @return
     */
    boolean delScore(int stuId);
}
