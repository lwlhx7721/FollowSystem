package com.jxd.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-10-09 18:27
 */
public interface IJobEvaluationDao {
    boolean delJobEvaluationByStuId(int stuId);
    boolean delJobEvaluationsByStuId(@Param("stuIds") String stuIds);
}
