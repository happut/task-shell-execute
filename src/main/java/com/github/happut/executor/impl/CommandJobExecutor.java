package com.github.happut.executor.impl;

import com.github.happut.executor.IJobExecutor;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public class CommandJobExecutor implements IJobExecutor {

    private String output;

    private String errout;

    private String command;

    public void setCommand(String command) {
        this.command = command;
    }

    @Override

    public boolean execute() {
        boolean flag = false;

        CommandLine commandline = CommandLine.parse(command);
        DefaultExecutor executor = new DefaultExecutor();

        executor.setExitValues(null);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream erroutStream = new ByteArrayOutputStream();

        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, erroutStream);
        executor.setStreamHandler(streamHandler);

        ExecuteWatchdog watchdog = new ExecuteWatchdog(10000);


        executor.setWatchdog(watchdog);
        try {
            executor.execute(commandline);
            flag = true;

        } catch (IOException e) {

        }


        output = outputStream.toString();
        errout = erroutStream.toString();
        return flag;
    }

    @Override
    public String getResult() {
        return "output:\n" + output + "\n" + "errout:" + errout + "\n";
    }

}
