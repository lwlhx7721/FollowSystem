package com.jxd.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-10-09 18:26
 */
public interface ISchoolEvaluationDao {
    boolean delSchoolEvaluationByStuId(int stuId);
    boolean delSchoolEvaluationsByStuId(@Param("stuIds") String stuIds);
}
