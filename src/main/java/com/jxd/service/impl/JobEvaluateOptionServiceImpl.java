package com.jxd.service.impl;

import com.jxd.dao.IJobEvaluateOptionDao;
import com.jxd.model.JobEvaluateOption;
import com.jxd.service.IJobEvaluateOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-23 11:19
 */
@Service
public class JobEvaluateOptionServiceImpl implements IJobEvaluateOptionService {
    @Autowired
    private IJobEvaluateOptionDao jobEvaluateOptionDao;

    /**
     * 添加工作评分项信息
     * @param jobEvaluateOption 工作评分项对象
     * @return 是否添加成功的标志
     */
    @Override
    public boolean addJobEvaluateOption(JobEvaluateOption jobEvaluateOption) {
        return jobEvaluateOptionDao.addJobEvaluateOption(jobEvaluateOption);
    }

    /**
     * 修改工作评分项的信息
     * @param jobEvaluateOption
     * @return
     */
    @Override
    public boolean updJobEvaluateOption(JobEvaluateOption jobEvaluateOption) {
        return jobEvaluateOptionDao.updJobEvaluateOption(jobEvaluateOption);
    }

    /**
     * 通过评分项ID修改评分项状态
     * @param optionId 评分项ID
     * @param optionState
     * @return 是否修改成功的标志
     */
    @Override
    public boolean updJobEvaluateOptionByOptionId(int optionId, int optionState) {
        return jobEvaluateOptionDao.updJobEvaluateOptionByOptionId(optionId,optionState);
    }

    /**
     * 批量删除工作评分项的信息
     * @param optionIds 评分项ID
     * @return 是否删除成功的标志
     */
    @Override
    public boolean delJobEvaluateOptionsByOptionId(int[] optionIds) {
        return jobEvaluateOptionDao.delJobEvaluateOptionsByOptionId(optionIds);
    }

    /**
     * 获取所有评分项信息
     * @return 评分项信息
     */
    @Override
    public List<JobEvaluateOption> getAllJobEvaluateOption() {
        return jobEvaluateOptionDao.getAllJobEvaluateOption();
    }

    /**
     * 通过评分项名获取评分项信息
     * @param optionName 评分项名
     * @return 评分项信息
     */
    @Override
    public List<JobEvaluateOption> getAllJobEvaluateOptionByOptionname(String optionName) {
        return jobEvaluateOptionDao.getAllJobEvaluateOptionByOptionname(optionName);
    }

    /**
     * 通过评分项名称进行分页查询
     * @param limit 每页条数
     * @param page 页码
     * @param optionName 评分项名称
     * @return 评分项信息
     */
    @Override
    public List<JobEvaluateOption> getAllJobEvaluateOption(int limit, int page, String optionName) {
        return jobEvaluateOptionDao.getAllJobEvaluateOption(limit, page, optionName);
    }

    /**
     * 通过评分项ID查询出对应的信息
     * @param optionId 评分项ID
     * @return 评分项对象
     */
    @Override
    public JobEvaluateOption getJobEvaluateOptionByoptionId(int optionId) {
        return jobEvaluateOptionDao.getJobEvaluateOptionByoptionId(optionId);
    }
}
