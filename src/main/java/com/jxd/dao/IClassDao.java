package com.jxd.dao;

import java.util.List;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 15:39
 */
public interface IClassDao {
    /**
     * 获取所有班级信息
     * @return 班级信息
     */
    List<Class> getAllClass();
}
