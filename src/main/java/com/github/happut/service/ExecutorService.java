package com.github.happut.service;

import com.github.happut.dao.mapper.ExecuteDao;
import com.github.happut.model.TaskShfilePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
@Service
public class ExecutorService {

    @Autowired
    private ExecuteDao dao;

    public List<TaskShfilePo> findAll(){
        return dao.findAll();
    }

    public TaskShfilePo findTaskShfileById(String id){
        return dao.findTaskShfileById(id);
    }
}
