package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by zhongyao on 2019-06-15.
 * 实现线程有四种方式
 */
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 1、继承Thread类
         */
        MyThread thread = new MyThread();
        thread.start();

        /**
         * 2、实现Runnable接口
         */
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        /**
         * 3、实现Callable接口，通过FutureTask包装器来创建Thread线程
         */
        //由Callable<Integer>创建一个FutureTask<Integer>对象：
        Callable oneCallable = new MyCallable();
        //FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，
        //它同时实现了Future和Runnable接口。
        FutureTask futureTask = new FutureTask(oneCallable);
        //由FutureTask<Integer>创建一个Thread对象
        Thread thread3 = new Thread(futureTask);
        thread3.start();

        /**
         * 4、使用ExecutorService、Callable、Future实现有返回结果的线程
         */
        int taskSize = 5;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable2(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }

        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

    }
}

