package com.github.happut.executor;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by bjwangfei3 on 2017/6/7.
 */
public class TaskExecute {
    private InputStream inputStream;
    private InputStream errorStream;
    private OutputStream outputStream;

    public TaskExecute(Process p) {
        this.errorStream = p.getErrorStream();
        this.inputStream = p.getInputStream();
        this.outputStream = p.getOutputStream();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getErrorStream() {
        return errorStream;
    }

    public void setErrorStream(InputStream errorStream) {
        this.errorStream = errorStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
