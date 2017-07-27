package com.github.happut.executor;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public interface IJobExecutor {
    /**
     * 执行任务
     * @return 任务执行结果
     */
    boolean execute();

    /**
     * 获得结果
     * @return 结果
     */
    String getResult();
}
