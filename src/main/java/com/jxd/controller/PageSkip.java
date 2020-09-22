package com.jxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author LuWenlong
 * @description Todo
 * @date 2020-09-21 10:01
 */
@Controller
public class PageSkip {
    /**
     * 跳转到index.jsp页面
     * @return
     */
    @RequestMapping("/index")
    public String login() {
        return "index";
    }
}
