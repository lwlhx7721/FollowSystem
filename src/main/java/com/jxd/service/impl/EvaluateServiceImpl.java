package com.jxd.service.impl;

import com.jxd.dao.ICourseDao;
import com.jxd.dao.IEvaluateDao;
import com.jxd.dao.IEvaluateDateDao;
import com.jxd.model.Course;
import com.jxd.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-28 11:58
 */
@Service
public class EvaluateServiceImpl implements IEvaluateService {
    @Autowired
    private IEvaluateDao evaluateDao;
    @Autowired
    private ICourseDao courseDao;
    @Autowired
    private IEvaluateDateDao evaluateDateDao;

    @Override
    public List<Map<String, Object>> getAllStuList() {
        return evaluateDao.getAllStuList(courseDao.getAllCourseByState(),evaluateDateDao.getAllEvaluate());
    }

    @Override
    public List<Map<String, Object>> getAllStuListByPage(int pageIndex, int pageSize) {
        int index = (pageIndex - 1) * pageSize;
        return evaluateDao.getAllStuListByPage(courseDao.getAllCourseByState(),evaluateDateDao.getAllEvaluate(),index,pageSize);
    }

    @Override
    public Map<String, Object> getStuByStuId(int stuId) {
        return evaluateDao.getStuByStuId(courseDao.getAllCourseByState(),stuId);
    }
}
