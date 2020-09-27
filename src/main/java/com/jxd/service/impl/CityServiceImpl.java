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

    /**
     * 根据父级id查询对应城市名
     * @param parentId 接收id查询城市名
     * @return 返回城市名、父级城市id、城市类型的集合
     */
    @Override
    public List<Map<String, Object>> getCity(int parentId) {
        return cityDao.getCity(parentId);
    }

    /**
     * 根据id查询城市名
     * @param id 接收id
     * @return 返回city对象
     */
    @Override
    public City getCityById(int id) {
        return cityDao.getCityById(id);
    }
}
