package com.example;

import java.util.Random;

/**
 * @author zhongyao
 * @date 2017/12/26
 * 控制执行流程
 */

public class ControlFlow {
    private static double random;

    public static void main(String args[]) {
        /**
         * 语句会重复执行，直到起控制作用的布尔表达式得到"假"的结果为止
         */
        while (condition()) {
            System.out.println(random + " true..");
        }

        /**
         * while与do while，do while至少会执行一次。
         */

        do {
            System.out.println(random + " true.....");
        } while (condition());

        /**
         * for循环
         * 初始化表达式 ; 布尔表达式 ; 步进
         */
        for (char c = 0; c < 128; c++) {
            if (Character.isLowerCase(c)) {
                System.out.println("value:" + (int)c + " character: " + c);
            }
        }
        /**
         * 初始化表达式 布尔表达式 步进都可以为空
         * 此时表示无限循环
         */
        //for (;;){
        //    System.out.println("哈哈");
        //}

        /**
         * foreach语法
         */
        Random random = new Random(47);
        float f[] = new float[10];
        for (int i = 0; i < 10; i++) {
            f[i] = random.nextFloat();
        }

        //这条语句定义了一个float类型的变量，继而将每一个f的元素赋值给x。
        for (float x : f) {
            System.out.println(x);
        }

        for (char c : "yao will be the best man!!!".toCharArray()) {
            System.out.println(c);
        }

        /**
         * return
         */
        System.out.println(testMethod(10, 5));
        System.out.println(testMethod(5, 10));
        System.out.println(testMethod(5, 5));

        /**
         * break   continue
         */
        for (int i = 0; i < 100; i++) {
            if (i == 74) { break; }
            if (i % 9 != 0) { continue; }
            System.out.print(i+" ");
        }
    }

    private static int testMethod(int i, int j) {
        if (i > j) {
            return 1;
        } else if (i < j) {
            return -1;
        } else {
            return 0;
        }
    }

    static boolean condition() {
        /**
         * [0,1)之间的随机数：Math.random()
         */
        random = Math.random();
        boolean result = random < 0.88;
        return result;
    }
}
