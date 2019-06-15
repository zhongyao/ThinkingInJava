package com.example.innerclass;

/**
 * Created by zhongyao on 2019-06-15.
 * 成员内部类
 */
public class Outter1 {

    static int i = 1;
    int j = 2;

    public static void test1() {
        System.out.println("外部类的静态方法");
    }

    public void test2() {
        System.out.println("外部类的非静态方法");
    }

    class Inner {
        public void test() {
            System.out.println("i = " + i);
            System.out.println("j = " + j);

            test1();
            test2();
        }
    }
}
