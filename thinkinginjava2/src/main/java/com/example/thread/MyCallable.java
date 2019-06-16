package com.example.thread;

import java.util.concurrent.Callable;

/**
 * Created by zhongyao on 2019-06-15.
 */
public class MyCallable<V> implements Callable<Object> {
    @Override
    public V call() throws Exception {
        System.out.println("3、实现Callable接口通过包装器来创建Thread线程");
        return null;
    }
}
