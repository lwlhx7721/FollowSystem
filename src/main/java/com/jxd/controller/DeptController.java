package com.jxd.controller;

import com.jxd.model.Dept;
import com.jxd.service.IDeptService;
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
 * @date 2020-09-23 16:23
 */
@Controller
public class DeptController {
    @Autowired
    private IDeptService deptService;

    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping("/toAddDept")
    public String toAddDept() {
        return "dept/addDept";
    }

    /**
     * 执行新增操作
     * @param dept 部门对象
     * @return 是否新增chengg的标志
     */
    @RequestMapping("/toAddDepts")
    @ResponseBody
    public Boolean toAddDepts(Dept dept) {
       boolean isAdd =  deptService.addDept(dept);
       return isAdd;
    }

    /**
     * 单个删除
     * @param deptId
     * @return
     */
    @RequestMapping("/delDeptByDeptId")
    @ResponseBody
    public Boolean delDeptByDeptId(int deptId ) {
        boolean isDel  = deptService.delDeptByDeptid(deptId);
        return isDel;
    }

    /**
     * 批量删除
     * @param deptIds
     * @return
     */
    @RequestMapping("/delDepts")
    @ResponseBody
    public Boolean delDepts(String deptIds) {
        boolean isDel = deptService.delDeptsByDeptids(deptIds);
        return isDel;
    }

    /**
     * 通过要修改信息的部门id查询出部门信息，回传给前台
     * @param deptId 部门id
     * @param model
     * @return
     */
    @RequestMapping("/getDeptByDeptId")
    public String getDeptByDeptId(int deptId , Model model) {
        Dept dept = deptService.getDeptByDeptId(deptId);
        model.addAttribute("dept",dept);
        return "forward:updateDept";
    }

    /**
     * 跳转到前台修改页面
     * @return
     */
    @RequestMapping("/updateDept")
    public String updateDept(){
        return "dept/updDept";
    }

    /**
     * 执行修改操作
     * @param dept 部门对象
     * @return 是否修改成功的标志
     */
    @RequestMapping("/toUpdateDept")
    @ResponseBody
    public Boolean toUpdateDept(Dept dept) {
        boolean isUpdate = deptService.updateDept(dept);
        return isUpdate;

    }

    /**
     * 获取部门所有信息，传递给前台页面
     * @param limit 条数
     * @param page 页码
     * @param deptName 部门名称
     * @return json对象
     */
    @RequestMapping("/getDeptList")
    @ResponseBody
    public Object getDeptList(int limit,int page,String deptName) {
        if(deptName == null) {
            deptName = "";
        }
        page = (page - 1)*limit;
        List<Dept>  deptListByPage = deptService.getAllDeptByPage(limit, page, deptName);
        List<Dept> deptList = deptService.getAllDeptByDeptname(deptName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", deptList.size());
        jsonObject.put("data", JSONArray.fromObject(deptListByPage));
        return jsonObject;
    }

    @RequestMapping("/deptList")
    public String deptList(){
        return "dept/deptList";
    }

}
