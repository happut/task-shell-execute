package com.github.happut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bjwangfei3 on 2017/6/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
