package com.example.chapter7;

import static java.lang.System.out;

/**
 * @author zhongyao
 * @date 2018/1/18
 *
 * 调用基类构造器必须是你在导出类构造器中要做的第一件事
 */

public class Cartoon extends Drawing {
    public Cartoon() {
        out.println("Cartoon constructor");
    }

    public Cartoon(int i) {
        super(i);
        out.println("Cartoon constructor" + i);
    }

    public static void main(String[] args) {

        /**
         * 构造过程是从基类"向外"扩散的，所以基类在导出类构造器可以访问它之前，就已经完成了初始化。（默认构造器）
         *
         */
        //Cartoon cartoon = new Cartoon();

        /**
         * 但是，如果没有默认的基类构造器或者想调用一个带参数的基类构造器，就必须用关键字super显式地编写调用基类构造器的语句，并配以适当的参数
         */
        Cartoon cartoon1 = new Cartoon(4);
    }
}
