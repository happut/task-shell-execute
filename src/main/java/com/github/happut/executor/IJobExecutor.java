package com.github.happut.executor;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public interface IJobExecutor {
    boolean execute();
    String getResult();
}
