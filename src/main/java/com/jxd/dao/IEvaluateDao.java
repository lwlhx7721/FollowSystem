package com.jxd.dao;

import com.jxd.model.Course;
import com.jxd.model.EvaluateDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-28 11:07
 */
public interface IEvaluateDao {
    List<Map<String,Object>> getAllStuList(@Param("courseList") List<Course> courseList,@Param("evaluateDateList") List<EvaluateDate> evaluateDateList);
    List<Map<String,Object>> getAllStuListByPage(@Param("courseList") List<Course> courseList,@Param("evaluateDateList") List<EvaluateDate> evaluateDateList,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
    Map<String, Object> getStuByStuId(@Param("courseList") List<Course> courseList,@Param("stuId") int stuId);
}
