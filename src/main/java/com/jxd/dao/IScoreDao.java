package com.jxd.dao;

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
}
