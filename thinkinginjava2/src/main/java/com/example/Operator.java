package com.example;

import java.util.Random;
/**
 * Created by zhongyao on 2017/12/18.
 */

public class Operator {
    public static void main(String args[]){

        //取100以内的随机数
        Random random = new Random();
        System.out.println(random.nextInt(100));

        /**
         * 自动递增/自动递减:
         * 对于前缀递增和前缀递减（++a/--a）,会先执行运算，在生成值；
         * 对于后缀递增和后缀递减（a++/a--）,会先生成值，再执行运算
         */

        int i = 1;
        System.out.println("i:"+i);
        System.out.println("i:"+ ++i);
        System.out.println("i:"+ i);
        System.out.println("i:"+ i++);
        System.out.println("i:"+ i);

        /**
         * 关系运算符
         */
        Integer n1 = new Integer(25);
        Integer n2 = new Integer(25);

        //false:==或!=比较的就是对象的引用
        System.out.println(n1 == n2);
        //true:equals比较的是两个对象的内容是否相同
        System.out.println(n1.equals(n2));



    }
}
