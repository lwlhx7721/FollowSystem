package com.jxd.service.impl;

import com.jxd.dao.IEvaluateDateDao;
import com.jxd.model.EvaluateDate;
import com.jxd.service.IEvaluateDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-29 14:13
 */
@Service
public class EvaluateDateServiceImpl implements IEvaluateDateService {
    @Autowired
    private IEvaluateDateDao evaluateDateDao;

    @Override
    public List<EvaluateDate> getAllEvaluate() {
        return evaluateDateDao.getAllEvaluate();
    }
}
