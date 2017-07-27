package com.github.happut.executor.impl;

import com.github.happut.executor.IJobExecutor;
import org.apache.commons.exec.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public class ShellJobExecutor implements IJobExecutor {

    public String output;

    public String errout;

    public String command;

    @Override
    public boolean execute() {
        CommandLine commandline = CommandLine.parse("");
        DefaultExecutor executor = new DefaultExecutor();


        executor.setExitValues(null);

//        PumpStreamHandler streamHandler = new PumpStreamHandler(System.out, System.err);
//        executor.setStreamHandler(streamHandler);

//        ExecuteWatchdog watchdog = new ExecuteWatchdog(10000);

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

//        executor.setWatchdog(watchdog);
        try {
            executor.execute(commandline, resultHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");


//        System.out.println(outputStream.toString("gbk")+"+"+errorStream.toString("gbk"));
        return false;

    }

    public static void main(String[] arg) throws IOException {
//        WindowsShExecutor windowsShExecutor = new WindowsShExecutor();
//        windowsShExecutor.execute("ping 127.0.0.1 -t");
//        windowsShExecutor.execute("java -version");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();


        new Thread(() -> {
            CommandLine commandline = CommandLine.parse("ping 127.0.0.1 -t");
            DefaultExecutor executor = new DefaultExecutor();


            executor.setExitValues(null);

            PumpStreamHandler streamHandler = new PumpStreamHandler(output, err);
            executor.setStreamHandler(streamHandler);

            ExecuteWatchdog watchdog = new ExecuteWatchdog(10000);

            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

            executor.setWatchdog(watchdog);
            try {
                executor.execute(commandline, resultHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
