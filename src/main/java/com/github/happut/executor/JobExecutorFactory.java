package com.github.happut.executor;

import com.github.happut.executor.impl.CommandJobExecutor;

public class JobExecutorFactory {
    public static IJobExecutor buildCommandJobExecutor(String cmd) {
        CommandJobExecutor job = new CommandJobExecutor();
        job.setCommand(cmd);
        return job;
    }

    public static void main(String[] arg) {
        IJobExecutor commandJobExecutor = JobExecutorFactory.buildCommandJobExecutor("ping 127.0.0.1 -t");
        commandJobExecutor.execute();
        System.out.println(commandJobExecutor.getResult());
        ;
    }
}
