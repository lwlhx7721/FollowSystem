package com.jxd.dao;

import com.jxd.model.Course;
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
    List<Map<String,Object>> getAllScoreByPage(@Param("pageSize")int pageSize, @Param("pageIndex")int pageIndex, @Param("stuName")String stuName, @Param("courseList") List<Course> courseList, @Param("classId") int classId);


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
    boolean addScore(@Param("stuId") int stuId,@Param("scoreList") List<Score> scoreList);
    /**
     * 根据学生id获取成绩信息
     * @param stuId 学生id
     * @return 成绩信息
     */
    List<Map<String, Object>> getScoreByStuId(@Param("stuId") int stuId);
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
    boolean delScore(@Param("stuId") int stuId);
    boolean delScores(@Param("stuIds") String stuIds);
}
