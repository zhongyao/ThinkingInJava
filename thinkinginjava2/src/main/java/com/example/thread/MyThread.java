package com.example.thread;

/**
 * Created by zhongyao on 2019-06-15.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("1、继承Thread类");
    }
}
