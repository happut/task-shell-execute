package com.github.happut.executor.impl;

import com.github.happut.executor.ShExecutor;
import com.github.happut.executor.TaskExecute;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public class LinuxShExecutor implements ShExecutor{
    @Override
    public void execute(String sh, PrintWriter writer) {

    }

    @Override
    public TaskExecute execute(String sh) throws IOException {
        return null;
    }
}
