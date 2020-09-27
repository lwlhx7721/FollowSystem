package com.jxd.dao;

import com.jxd.model.Score;
import com.jxd.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 19:23
 */
public interface IScoreDao {
    /**
     * 遍历所有课程
     * @return 课程集合
     */
    List<Map<String,Object>> getAllScoreByPage(@Param("pageSize")int pageSize, @Param("pageIndex")int pageIndex, @Param("stuName")String stuName);

    /**
     * 获取学生姓名
     * @return 结果集
     */
    List<Student> getStuName();
    /**
     * 遍历数据
     * @return 结果集
     */
    List<Score> getAllScore();
    /**
     * 添加学生成绩
     * @param score 成绩对象
     * @return 是否成功
     */
    boolean addScore(Score score);
    /**
     * 根据学生id获取成绩信息
     * @param stuId 学生id
     * @return 成绩信息
     */
    Score getScoreByStuId(int stuId);
    /**
     * 修改学生成绩
     * @param score 学生成绩
     * @return 是否成功
     */
    boolean updScore(Score score);
    /**
     * 根据学生编号以及课程编号删除成绩
     * @param stuId 学生编号
     * @param courseId 课程编号
     * @return
     */
    boolean delScore(int stuId,int courseId);
}