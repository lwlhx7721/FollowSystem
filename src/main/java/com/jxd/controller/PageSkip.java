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

    @RequestMapping("/rolesChoose")
    public String rolesChoose() {
        return "rolesChoose";
    }

}
