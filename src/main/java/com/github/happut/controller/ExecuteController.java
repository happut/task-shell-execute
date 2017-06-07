package com.github.happut.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
@Controller
@RequestMapping("/execute")
public class ExecuteController {



    @RequestMapping("list")
    public String list(HttpRequest request, HttpResponse response){




        return "list";
    };
}
