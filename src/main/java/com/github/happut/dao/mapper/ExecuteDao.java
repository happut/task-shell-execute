package com.github.happut.dao.mapper;

import com.github.happut.model.Task;
import com.github.happut.model.TaskResult;
import com.github.happut.model.TaskShfilePo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
@Mapper
public interface ExecuteDao {


    @Select("select id as id,sh_file as shFile,bz as bz from t_task_shfile")
    public List<TaskShfilePo> findAll();

    @Select("select id as id,sh_file as shFile,bz as bz from t_task_shfile where id=#{id}")
    public TaskShfilePo findTaskShfileById(@Param(value = "id") String id);

    @Select("select * from t_task where id=#{id}")
    public Task findTaskById(@Param(value = "id") String id);

    @Insert("insert into t_task_result(id,taskId,executeTime,status,result) values(#{id},#{taskId},#{executeTime},#{status},#{result})")
    public void insertTaskResult(TaskResult taskResult);

}
