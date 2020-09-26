package com.jxd.service;

import com.jxd.model.Dept;

import java.util.List;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 15:37
 */
public interface IClassService {
    /**
     * 获取所有班级信息
     * @return 班级信息
     */
    List<Class> getAllClass();
}
