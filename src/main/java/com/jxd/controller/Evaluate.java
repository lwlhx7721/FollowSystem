package com.jxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-27 17:18
 */
@Controller
public class Evaluate {

    @RequestMapping("/stuList")
    public String stuList() {
        return "evaluate/stuList";
    }

    @RequestMapping("/evaluate")
    public String evaluate() {
        return "evaluate/evaluate";
    }


}
