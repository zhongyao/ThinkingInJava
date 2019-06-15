package com.example.innerclass;

/**
 * Created by zhongyao on 2019-06-15.
 *
 * 内部类有四种：
 * 1、静态内部类：作为类的静态成员，存在与某个类的内部
 * 2、成员内部类：作为类的成员，存在与某个类的内部
 * 3、局部内部类：存在于某个方法的内部
 * 4、匿名内部类：存在于某个类的内部，但是无名的类
 */
public class TestInner {

    public static void main(String[] args) {
        /**
         * 静态内部类测试:
         * 静态内部类的对象可以直接创建，无需先创建外部类的对象
         *
         */
        //Outter.Inner inner = new Outter.Inner();
        //inner.test2();

        /**
         * 成员内部类测试:
         * 成员内部类可以调用外部类的所有成员，但只有在创建了外部类的对象之后，才能调用外部的成员
         */
        //Outter1.Inner inner1 = new Outter1().new Inner();
        //inner1.test();

        /**
         * 局部内部类测试：
         * 局部内部类只能在方法内部使用，一旦方法执行完毕，局部内部类就会从内存中删除。
         */
        //Outter2 outter2 = new Outter2();
        //outter2.test(9);

        /**
         * 匿名内部类测试：
         * 大括号是匿名内部类的主体，这个主体是类或者接口的实现。如果是类，那么匿名内部类是该类的子类；
         * 如果是接口，匿名内部类就要完成接口的实现。
         */

        Outter3 outter3 = new Outter3();
        outter3.show(new Message() {
            @Override
            public void show() {
                super.show();
                System.out.println("在匿名内部类中");
            }
        });

    }
}
