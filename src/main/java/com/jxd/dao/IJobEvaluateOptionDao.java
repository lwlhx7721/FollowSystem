package com.jxd.dao;

import com.jxd.model.JobEvaluateOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-23 10:55
 */
public interface IJobEvaluateOptionDao {
    /**
     * 添加工作评分项信息
     * @param jobEvaluateOption 工作评分项对象
     * @return 是否添加成功的标志
     */
    boolean addJobEvaluateOption(JobEvaluateOption jobEvaluateOption);

    /**
     * 修改工作评分项的信息
     * @param jobEvaluateOption
     * @return
     */
    boolean updJobEvaluateOption(JobEvaluateOption jobEvaluateOption);

    /**
     * 通过评分项ID修改评分项状态
     * @param optionId 评分项ID
     * @return 是否修改成功的标志
     */
    boolean updJobEvaluateOptionByOptionId(@Param("optionId") int optionId,@Param("optionState") int optionState);

    /**
     * 批量删除工作评分项的信息
     * @param optionIds 评分项ID
     * @return 是否删除成功的标志
     */
    boolean delJobEvaluateOptionsByOptionId(int[] optionIds);

    /**
     * 获取所有评分项信息
     * @return 评分项信息
     */
    List<JobEvaluateOption> getAllJobEvaluateOption();

    /**
     * 通过评分项名获取评分项信息
     * @param optionName 评分项名
     * @return 评分项信息
     */
    List<JobEvaluateOption> getAllJobEvaluateOptionByOptionname(String optionName);

    /**
     * 通过评分项名称进行分页查询
     * @param limit 每页条数
     * @param page 页码
     * @param optionName 评分项名称
     * @return 评分项信息
     */
    List<JobEvaluateOption>getAllJobEvaluateOption(@Param("limit") int limit, @Param("page") int page, @Param("optionName") String optionName);

    /**
     * 通过评分项ID查询出对应的信息
     * @param optionId 评分项ID
     * @return 评分项对象
     */
    JobEvaluateOption getJobEvaluateOptionByoptionId(int optionId);

}
