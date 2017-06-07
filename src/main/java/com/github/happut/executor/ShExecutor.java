package com.github.happut.executor;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public interface ShExecutor {
    public void execute(String sh, PrintWriter writer) throws IOException;

    public TaskExecute execute(String sh) throws IOException;
}
