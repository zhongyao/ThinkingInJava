package com.example;

/**
 * Created by zhongyao on 2018/1/1.
 * 初始化与清理
 */

public class Chapter5InitializeAndClear {
    public static void main(String args[]) {
        /**
         * 用构造器确保初始化:
         * "初始化"与"创建"捆绑在一起，两者不能分开
         */
        Rock rock = new Rock(2);

        /**
         * 方法重载：
         * 1>方法名相同，参数不相同
         * 每个重载的方法都必须有一个独一无二的参数类型列表（包括参数相同，但顺序不同的情况）
         */
        Tree tree = new Tree();
        tree.info();

        Tree treeHeight = new Tree(30);
        treeHeight.info(30);

        /**
         * 2>计普通类型的方法重载：
         *如果传入的数据类型（实参类型）小于方法中的形参类型，实参类型就会被提升【小则提升】
         *
         *如果传入的数据类型（实参类型）大于方法中的形参类型，实参类型需要强转至形参类型【大则强转】
         *
         *char则略有不同，如果输入的数据类型（实参类型）为char，如果无法找到恰好接受char参数的方法，
         *就会把char直接提升至int型。
         */
        Tree treeType = new Tree();
        treeType.control(10);
        treeType.control((float)10.0);
        treeType.control('a');

        /**
         * 默认构造器（无参构造器）：
         * 如果某类中没有该构造器，则编译器会帮你自动创建一个默认构造器；
         * 但是如果已经定义了一个构造器（无论是否有参数），编译器就不会帮你自动创建默认构造器
         */

        /**
         * this:
         * 由于increment通过this关键字返回了当前对象的引用，所以很容易在一条语句里对同一个对象进行多次操作。
         * this关键字对于将当前对象传递给其他方法也很有用。
         */
        Leaf leaf = new Leaf();
        leaf.increment().increment().increment().print();

        Person person = new Person();
        Apple apple = new Apple();
        person.eat(apple);

        /**
         * 在构造器中调用构造器：
         * 必须将构造器置于最起始处
         */
        Flower flower = new Flower();
        flower.create();

        createElement("哈哈");

    }

    private static void createElement(String s, String h) {
        System.out.println("s:" + s + "h:" + h);
    }

    private static void createElement(String s) {
        createElement(s, "");
    }
}

class Flower {

    Flower() {
        this("哈哈");
        System.out.println("Flower Constructor:none");
    }

    Flower(String seed) {
        this("哈哈哈", 34);
        System.out.println("Flower Constructor:seed");
    }

    Flower(String seed, int quantity) {
        System.out.println("Flower Constructor:seed + quantity");
    }

    void create() {
        System.out.println("grow flower");
    }
}

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("yao");

    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Leaf {
    int i = 0;

    Leaf increment() {
        i++;
        return this;
    }

    void print() {
        System.out.println(i);
    }
}

class Tree {
    Tree() {
        System.out.println("Tree");
    }

    Tree(int height) {
        System.out.println("Tree:" + height);
    }

    public void info() {
        System.out.println("a small tree");
    }

    public void info(int height) {
        System.out.println("a big tree:" + height);
    }

    public void control(float x) {
        System.out.println("control:" + x);
    }

    public void control(int x) {
        System.out.println("control:" + x);
    }

}

class Rock {
    Rock(int i) {
        System.out.print("Rock " + i);
    }
}
