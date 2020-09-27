package com.jxd.service.impl;

import com.jxd.dao.IClassDao;
import com.jxd.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 15:38
 */
@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;

    /**
     * 获取所有班级信息
     * @return 班级信息
     */
    @Override
    public List<Class> getAllClass() {
        return classDao.getAllClass();
    }
}
