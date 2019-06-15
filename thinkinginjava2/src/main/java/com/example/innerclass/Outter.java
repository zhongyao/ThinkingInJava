package com.example.innerclass;

/**
 * Created by zhongyao on 2019-06-15.
 * 静态内部类
 */
public class Outter {
    static int i = 1;
    int j = 2;

    static void test() {
        System.out.print("外部类静态方法");
    }

    static class Inner {
        public void test2(){
            //直接引用外部类的静态成员变量
            System.out.println("i = "+ i);
            //直接引用外部类的静态方法
            test();
            //无法直接引用外部类的非静态成员变量(报错)
            //System.out.println("j = " + j);


        }
    }
}
