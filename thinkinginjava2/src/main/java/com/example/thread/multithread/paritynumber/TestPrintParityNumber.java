package com.example.thread.multithread.paritynumber;

/**
 * 使用两个线程交替打印奇偶数
 */
public class TestPrintParityNumber {
    public static void main (String[] args) {
        new Thread(new MyRunnable(), "线程1").start();
        new Thread(new MyRunnable(), "线程2").start();
    }
}
