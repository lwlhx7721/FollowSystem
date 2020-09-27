package com.jxd.service.impl;

import com.jxd.dao.ICityDao;
import com.jxd.model.City;
import com.jxd.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ShiWenZhe
 * @description 新增学生时出生地的级联框
 * @date 2020-09-23 17:36
 */
@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private ICityDao cityDao;

    @Override
    public List<Map<String, Object>> getCity(int parentId) {
        return cityDao.getCity(parentId);
    }

    @Override
    public City getCityById(int id) {
        return cityDao.getCityById(id);
    }
}
