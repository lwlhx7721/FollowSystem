package com.jxd.service;

import java.util.List;
import java.util.Map;

/**
 * @author WangLingzhe
 * @description Todo
 * @date 2020-09-23 19:22
 */
public interface IScoreService {
    /**
     * 遍历所有课程
     * @return 课程集合
     */
    List<Map<String,Object>> getAllScoreByPage(int pageSize, int pageIndex, String stuName);
}
