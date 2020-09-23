package com.jxd.service.impl;

import com.jxd.dao.IScoreDao;
import com.jxd.service.IScoreService;
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
    public List<Map<String, Object>> getAllScoreByPage(int pageSize, int pageIndex, String stuName) {
        return scoreDao.getAllScoreByPage(pageSize, pageIndex, stuName);
    }
}
