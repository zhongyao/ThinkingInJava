package com.example.thread.multithread.paritynumber;

public class MyRunnable implements Runnable {
    private int value = 0;
    @Override
    public void run() {
        while (value <= 100) {
            synchronized (MyRunnable.class) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ":" + value++);
                MyRunnable.class.notify();
                //此处判断，是为了打印完了100个数字后，程序能够正常结束，否则程序将一直等待下去，耗费系统资源。
                if (value <= 100) {
                    try {
                        MyRunnable.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
