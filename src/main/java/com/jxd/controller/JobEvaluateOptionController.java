package com.jxd.controller;

import com.jxd.model.JobEvaluateOption;
import com.jxd.service.IJobEvaluateOptionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ZhangXinyun
 * @description Todo
 * @date 2020-09-24 00:50
 */
@Controller
public class JobEvaluateOptionController {
    @Autowired
    private IJobEvaluateOptionService jobEvaluateOptionService;

    @RequestMapping("/jobEvaluateOptionList")
    public String jobEvaluateOptionList() {
        return "jobevaluateoption/jobEvaluateoptionList";
    }
    /**
     * 跳转到添加评分项页面
     * @return
     */
    @RequestMapping("/addJobEvaluateOptions")
    public String addJobEvaluateOptions() {
        return "jobevaluateoption/addJobEvaluateOption";
    }

    /**
     * 执行新增评分项操作
     * @param jobEvaluateOption 评分项对象
     * @return
     */
    @RequestMapping("/toAddJobEvaluateOption")
    @ResponseBody
    public Boolean toAddJobEvaluateOption(JobEvaluateOption jobEvaluateOption) {
        boolean isAdd = jobEvaluateOptionService.addJobEvaluateOption(jobEvaluateOption);
        return isAdd;
    }

    /**
     * 通过要修改评分项ID查询出要修改评分项信息，回传给前台
     * @param optionId 评分项ID
     * @param model
     * @return
     */
    @RequestMapping("/toUpdJobEvaluateOption")
    public String toUpdJobEvaluateOption(int optionId, Model model){
        JobEvaluateOption jobEvaluateOption = jobEvaluateOptionService.getJobEvaluateOptionByoptionId(optionId);
        model.addAttribute("jobEvaluateOption",jobEvaluateOption);
        return "forward:updateJobEvaluateOption";
    }

    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping("/updateJobEvaluateOption")
    public String updateJobEvaluateOption() {
        return "jobevaluateoption/updJobEvaluateOption";
    }

    /**
     * 执行修改评分项操作
     * @param jobEvaluateOption 评分项对象
     * @return
     */
    @RequestMapping("/toUpdateJEO")
    @ResponseBody
    public Boolean toUpdateJEO(JobEvaluateOption jobEvaluateOption) {
       boolean isUpd =  jobEvaluateOptionService.updJobEvaluateOption(jobEvaluateOption);
       return isUpd;
    }

    /**
     * 执行删除操作
     * @param optionId 评分项ID
     * @param model
     * @return
     */
    @RequestMapping("/delJobEvaluateOptionByOptionId")
    @ResponseBody
    public String delJobEvaluateOptionByOptionId(int optionId){
        JobEvaluateOption jobEvaluateOption = jobEvaluateOptionService.getJobEvaluateOptionByoptionId(optionId);
        int optionState = jobEvaluateOption.getOptionState();
        String msg = null;
        if(optionState == 1) {
            msg = "msg";
           return msg;
        }else {
            boolean isDel = jobEvaluateOptionService.delJobEvaluateOptionByOptionId(optionId);
            if(isDel) {
                msg = "true";
                return msg;
            } else {
                msg = "false";
                return msg;
            }

        }
    }

    /**
     *
     * @param limit 条数
     * @param page 页码
     * @param optionName 评分项名称
     * @return json对象
     */
    @RequestMapping("/getJobEvaluateOptionList")
    @ResponseBody
    public Object getJobEvaluateOptionList(int limit,int page,String optionName) {
        if(optionName == null){
            optionName = "";
        }
        page = (page - 1)*limit;
        List<JobEvaluateOption> jobEvaluateOptionList =  jobEvaluateOptionService.getAllJobEvaluateOptionByOptionname(optionName);
        List<JobEvaluateOption> jobEvaluateOptionListByPage = jobEvaluateOptionService.getAllJobEvaluateOption(limit, page, optionName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", jobEvaluateOptionList.size());
        jsonObject.put("data", JSONArray.fromObject(jobEvaluateOptionListByPage));
        return jsonObject;
    }

}
