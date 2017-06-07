package com.github.happut.executor.impl;

import com.github.happut.executor.ShExecutor;
import com.github.happut.executor.TaskExecute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public class WindowsShExecutor implements ShExecutor {
    @Override
    public void execute(String sh, PrintWriter writer) throws IOException {
        Runtime r = Runtime.getRuntime();
        Process exec = r.exec(sh);
        BufferedReader br = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
        String line;
        while ((line = br.readLine()) != null) {
            writer.println(line);
        }
    }

    @Override
    public TaskExecute execute(String sh) throws IOException {
        Runtime r = Runtime.getRuntime();
        return new TaskExecute(r.exec(sh));
    }

    public static void main(String[] arg) throws IOException {
        Runtime r = Runtime.getRuntime();
        Process exec = r.exec("java -version");
        BufferedReader br = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
