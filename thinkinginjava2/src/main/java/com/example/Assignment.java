package com.example;

/**
 * Created by zhongyao on 2017/12/18.
 *
 * 别名问题：
 *
 * 对一个对象进行操作时，我们真正操作的是对对象的引用
 * 所以应尽量避免为对象赋值，避免意向不到的问题出现
 *
 */

public class Assignment {
    public static void main(String args[]) {

        Tank t1 = new Tank();
        Tank t2 = new Tank();

        t1.level = 23;
        t2.level = 28;

        System.out.println("t1.level:" + t1.level + " t2.level:" + t2.level);

        /**
         倘若将"对象赋值给另一个对象"，实际是将"引用"从一个地方赋值到另一个地方
         (t1和t2)都指向原本只有t2指向的那个对象
         */
        t1 = t2;

        System.out.println("t1.level:" + t1.level + " t2.level:" + t2.level);

        //t2.level = 35;
        t1.level = 45;

        System.out.println("t1.level:" + t1.level + " t2.level:" + t2.level);
    }
}

class Tank {
    int level;
}