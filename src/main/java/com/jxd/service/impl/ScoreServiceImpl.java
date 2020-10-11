package com.jxd.service.impl;

import com.jxd.dao.IScoreDao;
import com.jxd.model.Course;
import com.jxd.model.Score;
import com.jxd.model.Student;
import com.jxd.service.IScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 19:23
 */
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private IScoreDao scoreDao;
    /**
     * 遍历所有课程
     * @return 课程集合
     */
    @Override
    public List<Map<String, Object>> getAllScoreByPage(int pageSize, int pageIndex, String stuName, List<Course> courseList, int classId) {
        int PageIndex = (pageIndex - 1)*pageSize;
        return scoreDao.getAllScoreByPage(pageSize, PageIndex, stuName, courseList, classId);
    }
    /**
     * 获取学生姓名
     * @return 结果集
     */
    @Override
    public List<Map<String,Object>> getStuNameByClass(int classId) {
        return scoreDao.getStuNameByClass(classId);
    }

    /**
     * 遍历数据
     * @return 结果集
     */
    @Override
    public List<Score> getAllScore() {
        return scoreDao.getAllScore();
    }

    /**
     * 添加学成绩
     * @param stuId 学员id
     * @param scoreList 成绩集合
     * @return 返回是否成功
     */
    @Override
    public boolean addScore(int stuId, List<Score> scoreList) {
        return scoreDao.addScore(stuId, scoreList);
    }

    /**
     * 根据学生id获取成绩信息
     * @param stuId 学生id
     * @return 成绩信息
     */
    @Override
    public List<Map<String, Object>>getScoreByStuId(int stuId) {
        return scoreDao.getScoreByStuId(stuId);
    }

    /**
     * 修改学生成绩
     * @param score 学生成绩
     * @return 是否成功
     */
    @Override
    public boolean updScore(Score score) {
        return scoreDao.updScore(score);
    }
    /**
     * 根据学生编号以及课程编号删除成绩
     * @param stuId 学生编号
     * @return
     */
    @Override
    public boolean delScore(int stuId) {
        return scoreDao.delScore(stuId);
    }
}
