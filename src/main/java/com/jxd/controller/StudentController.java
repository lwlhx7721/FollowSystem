package com.jxd.controller;

import com.jxd.model.City;
import com.jxd.model.ListData;
import com.jxd.model.Student;
import com.jxd.service.ICityService;
import com.jxd.service.IClassService;
import com.jxd.service.IDeptService;
import com.jxd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ShiWenZhe
 * @description Todo
 * @date 2020-09-23 10:34
 */
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private IClassService classService;
    @Autowired
    private ICityService cityService;


    @RequestMapping("/getStudentList")
    @ResponseBody
    public ListData getStudentList(String name, String classId, String deptId,String limit, String page) {
        String stuName = name == null ? "" : name;
        int cId = classId == null ? 0 : Integer.parseInt(classId);
        int limit1 = limit == null ? 0 : Integer.parseInt(limit);
        int page1 = page == null ? 0 : Integer.parseInt(page);
        int dId = deptId == null ? 0 : Integer.parseInt(deptId);
        List<Map<String, Object>> studentList = studentService.getAllStudentByPage(stuName, cId, dId, page1, limit1);
        int size = studentService.getAllStudent(stuName, cId, dId).size();
        ListData studentData = new ListData(size,studentList);
        return studentData;
    }

    @RequestMapping("/studentList")
    public String getDeptAndClassList(Model model) {
        model.addAttribute("deptList",deptService.getAllDept());
        model.addAttribute("classList",classService.getAllClass());
        return "student/studentList";
    }

    @RequestMapping("/cityList")
    public String cityList(int parentId, int type, Model model) {
        model.addAttribute("classList",classService.getAllClass());
        List<Map<String, Object>> cityList = cityService.getCity(parentId);
        model.addAttribute("cityList", cityList);
        return "student/addStudent";
    }

    @RequestMapping(value = "/getCity", method = RequestMethod.POST )
    @ResponseBody
    public List<Map<String, Object>>  getCity(int parentId) {
        List<Map<String, Object>>  list = cityService.getCity(parentId);
        return list;
    }

    //图片上传测试
    @ResponseBody
    @RequestMapping("upload")
    public Map upload(MultipartFile file,HttpServletRequest request){
        String prefix="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file != null) {
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                String uuid = UUID.randomUUID()+"";
                String filepath = "D:\\study\\java\\FollowSystem\\src\\main\\webapp\\static\\files\\"+uuid+"." + prefix;
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map2 = new HashMap<>();
                Map<String,Object> map = new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                map2.put("src","../../static/files/" + uuid + "." + prefix);
                return map;
            }

        }catch (Exception e){
        }finally{
            try {
                if(out != null){
                    out.close();
                }
                if(fileInput != null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;

    }

    /**
     * 删除文件
     * @param fileName
     * @param request
     * @return
     */
    @RequestMapping(value = "/delFile" ,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delFile(String fileName, HttpServletRequest request) {
        String filePath = request.getServletContext().getRealPath("/" + fileName);
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return "删除成功";
            } else {
                return "删除失败";
            }
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("/addStudents")
    @ResponseBody
    public boolean addStudents(Student student, String province, String city, String area) {
        System.out.println(province);
        int provinceId = province == null ? 0:Integer.parseInt(province);
        int cityId = city == null ? 0:Integer.parseInt(city);
        int areaId = area == null ? 0:Integer.parseInt(area);
        student.setBirthPlace(cityService.getCityById(provinceId).getCityName() + cityService.getCityById(cityId).getCityName()
                +  cityService.getCityById(areaId).getCityName());
        return studentService.addStudents(student);
    }

    @RequestMapping(value = "/detailStudent",produces = "text/html;charset=UTF-8")
    public String getStudentsByID(String stuId,Model model) {
        int id = stuId == null ? 0:Integer.parseInt(stuId);
        List<Map<String, Object>> list = studentService.getStudentById(id);
        model.addAttribute("list", list);
        return "student/detailStudent";
    }
    @RequestMapping(value = "/updStudent",produces = "text/html;charset=UTF-8")
    public String updStudentsByID(String stuId,Model model,int parentId) {
        model.addAttribute("classList",classService.getAllClass());
        List<Map<String, Object>> cityList = cityService.getCity(parentId);
        model.addAttribute("cityList", cityList);
        int id = stuId == null ? 0:Integer.parseInt(stuId);
        List<Map<String, Object>> list = studentService.getStudentById(id);
        model.addAttribute("list", list);
        return "student/updStudent";
    }

    @RequestMapping("/updStudents")
    @ResponseBody
    public boolean updStudents(Student student, String province, String city, String area) {
        System.out.println(province + city + area);
        System.out.println(student.getStuName());
        int provinceId = province == null ? 0:Integer.parseInt(province);
        int cityId = city == null ? 0:Integer.parseInt(city);
        int areaId = area == null ? 0:Integer.parseInt(area);
        student.setBirthPlace(cityService.getCityById(provinceId).getCityName() + cityService.getCityById(cityId).getCityName()
                +  cityService.getCityById(areaId).getCityName());
        return studentService.updStudents(student);
    }

    @RequestMapping(value = "delStudentByStuId",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String delStudentByStuId(String stuId) {
        int id = stuId == null ? 0:Integer.parseInt(stuId);
        if(studentService.delStudentByStuId(id)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("/delAllStudentsById")
    @ResponseBody
    public Boolean delAllStudentById(String stuIds) {
        System.out.println(stuIds);
        return studentService.delStudentsById(stuIds);
    }
}
