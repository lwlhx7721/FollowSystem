package com.jxd.service;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-28 11:44
 */
public interface IEvaluateService {
    List<Map<String,Object>> getAllStuList();
    List<Map<String,Object>> getAllStuListByPage(int pageIndex, int pageSize);
    Map<String, Object> getStuByStuId(int stuId);
}
