package com.example.innerclass;

/**
 * Created by zhongyao on 2019-06-15.
 * 局部内部类
 */
public class Outter2 {

    static int i = 1;
    int j = 2;

    public void test(final int n) {
        final int m = 0;
        class Inner {
            void testInner() {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println("n = " + n);
                System.out.println("m = " + m);
            }
        }

        Inner inner = new Inner();
        inner.testInner();
    }
}
