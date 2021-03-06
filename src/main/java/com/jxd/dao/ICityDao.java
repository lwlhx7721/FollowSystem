package com.jxd.dao;

import com.jxd.model.City;

import java.util.List;
import java.util.Map;

/**
 * @author ShiWenZhe
 * @description 新增学生时出生地的级联框
 * @date 2020-09-23 17:36
 */
public interface ICityDao {
    /**
     * 根据id查询对应城市名
     * @param parentId 接收id查询城市名
     * @return 返回城市名、父级城市id、城市类型的集合
     */
    List<Map<String, Object>> getCity(int parentId);

    /**
     * 根据id查询城市名
     * @param id 接收id
     * @return 返回city对象
     */
    City getCityById(int id);
}
