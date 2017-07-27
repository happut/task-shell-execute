package com.github.happut.controller;

import com.github.happut.executor.IJobExecutor;
import com.github.happut.executor.JobExecutorFactory;
import com.github.happut.model.Task;
import com.github.happut.model.TaskShfilePo;
import com.github.happut.service.ExecutorService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
@RestController
@RequestMapping("/execute")
public class ExecuteController {

    @Autowired
    private ExecutorService service;

    @RequestMapping("list")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        List<TaskShfilePo> shfilePos = service.findAll();
        request.setAttribute("shfilePos",shfilePos);

//        WindowsShExecutor e = new WindowsShExecutor();
//        try {
//            //e.execute(shfilePos.get(0).getShFile(),response.getWriter());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }


        return "execute/list";
    }

    @RequestMapping("run")
    public String list(@RequestParam("id")String id) {
        Task task = service.findTaskById(id);
        IJobExecutor iJobExecutor = JobExecutorFactory.buildCommandJobExecutor(task.getCommand());
        boolean status = iJobExecutor.execute();
        String result = iJobExecutor.getResult();
        JSONObject json = new JSONObject();
        json.put("status",status);
        json.put("result",result);
        return json.toString();
    }

}
