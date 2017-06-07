package com.github.happut.controller;

import com.github.happut.executor.TaskExecute;
import com.github.happut.executor.impl.WindowsShExecutor;
import com.github.happut.model.TaskShfilePo;
import com.github.happut.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
@Controller
@RequestMapping("/execute")
public class ExecuteController {

    @Autowired
    private ExecutorService service;

    @RequestMapping("list")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        List<TaskShfilePo> shfilePos = service.findAll();
        request.setAttribute("shfilePos",shfilePos);

        WindowsShExecutor e = new WindowsShExecutor();
        try {
            e.execute(shfilePos.get(0).getShFile(),response.getWriter());
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return "execute/list";
    }

    @RequestMapping("run")
    @ResponseBody
    public String list(@RequestParam("id")String id) {
        TaskShfilePo shfilePo = service.findTaskShfileById(id);


        WindowsShExecutor e = new WindowsShExecutor();
        try {
            TaskExecute execute = e.execute(shfilePo.getShFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(execute.getErrorStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return "execute/list";
    }

    ;
}
