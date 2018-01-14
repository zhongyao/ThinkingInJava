package com.example;

import java.util.Random;

/**
 * Created by zhongyao on 2017/12/18.
 */

public class Operator {
    public static void main(String args[]) {

        //取100以内的随机数
        Random random = new Random();
        System.out.println(random.nextInt(100));

        /**
         * 自动递增/自动递减:
         * 对于前缀递增和前缀递减（++a/--a）,会先执行运算，在生成值；
         * 对于后缀递增和后缀递减（a++/a--）,会先生成值，再执行运算
         */

        int i = 1;
        System.out.println("i:" + i);
        System.out.println("i:" + ++i);
        System.out.println("i:" + i);
        System.out.println("i:" + i++);
        System.out.println("i:" + i);

        /**
         * 关系运算符
         */
        Integer n1 = new Integer(25);
        Integer n2 = new Integer(25);

        //false:==或!=比较的就是对象的引用
        System.out.println(n1 == n2);
        //true:equals比较的是两个对象的内容是否相同

        /**
         * 指数计数法
         */
        //真正的含义是:1.39/Math.pow(10,-43);
        float f = 1.39e-43f;
        double d = 47e47d;
        System.out.println(f);
        System.out.println(d);

        //e的x次方
        System.out.println(Math.exp(2));

        /**
         * 按位操作符
         * 与：&
         * 或：|
         * 非：~
         * 异或：^ 相同为0，不同为1
         */

        //八进制
        int octal = 012;
        //十六进制
        int hexadecimal = 0x12;

        int number = 18;

        System.out.println(octal);
        System.out.println(hexadecimal);
        //将整形number转换成二进制类型
        System.out.println(Integer.toBinaryString(number));

        //10010
        int a = 18;
        //00110
        int b = 6;

        //00010   2
        System.out.println(a & b);
        //10110   22
        System.out.println(a | b);
        //a : 00010010  ~a: 11101101
        System.out.println(~a);
        //10100   20
        System.out.println(a ^ b);

        /**
         * 原码：如果机器字长为n，那么一个数的原码就是用一个n位的二进制数，其中最高位为符号位：正数为0，负数为1。剩下的n-1位表示概数的绝对值
         * X=+101011 , [X]原= 00101011    X=-101011 , [X]原= 10101011
         * 反码：因为反码就是在原码的基础上，符号位不变其他位按位取反(就是0变1，1变0)就可以了
         * X=-101011 , [X]原= 10101011 ，[X]反=11010100
         * 补码：在反码的基础上按照正常的加法运算加1
         * X=-101011 , [X]原= 10101011 ，[X]反=11010100，[X]补=11010101
         * X=-1111111   原码= 11111111 反码= 10000000 补码 = 10000001
         */

        /**
         * 移位操作符：
         * 1、左移位操作符（<<）:
         * 能够按照操作符右侧指定的位数将操作符左边的操作数向左移动（在低位补0）
         * 2、"有符号"右移操作符（>>）:
         * 按照操作符右侧指定的位数将操作符左边的操作数向右移动。若符号为正，则在高位插入0；若符号为负，则在高位插入1.
         * 3、"无符号"右移操作符(>>>):
         * 无论正负都在高位插入0.从VB你
         */
    }
}
