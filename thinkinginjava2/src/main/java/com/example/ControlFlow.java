package com.example;

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
        for (;;){
            System.out.println("哈哈");
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
