package com.example.thread;

import java.util.concurrent.Callable;

/**
 * Created by zhongyao on 2019-06-15.
 */
public class MyCallable2 implements Callable<Object> {
    private String s;

    public MyCallable2(String s) {
        this.s = s;
    }

    @Override
    public Object  call() throws Exception {
        System.out.println("4、使用ExecutorService、Callable、Future有返回结果的线程---s:" + s);
        return s;
    }
}
