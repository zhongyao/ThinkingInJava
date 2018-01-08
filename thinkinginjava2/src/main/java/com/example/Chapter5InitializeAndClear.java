package com.example;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

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

        /***
         * 构造器初始化:
         * i首先被置为0,然后变成7
         */
        Counter counter = new Counter(6);

        /**
         * 初始化顺序：
         * 在类的内部，变量定义的先后顺序决定了初始化的顺序，
         * 即使变量定义散布于方法定义之间，它们仍旧会在任何方法被调用之前得到初始化
         */
        House house = new House();
        house.function();

        /**
         * 显示的静态初始化
         */

        out.println("inside main()");
        //不会调用Cups的构造方法
        Cups.cup1.f(1);

        //会调用Cups的构造方法
        //new Cups();

        /**
         * 数组初始化
         */
        Random random = new Random(47);
        int[] a = new int[random.nextInt(20)];
        out.println("length of a =" + a.length);
        out.println(Arrays.toString(a));

        Random random1 = new Random(47);
        Integer[] a1 = new Integer[random1.nextInt(20)];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = random1.nextInt(500);
        }
        out.println("length of a1 =" + a1.length);
        out.println(Arrays.toString(a1));

        /**
         * 可变参数列表
         */
        printMyArray(new Object[] {new Integer(39), new Float(34.3), new Double(33.5)});
        printMyArray(new Object[] {"one", "two", "three"});
        printMyArray(new Object[] {new A(), new A(), new A()});

        //将0个参数传递给可变参数列表是可行的，当具有可选的尾随参数时，这一特性会比较有用
        f(1, "one");
        f(2, "two", "three");
        f(0);

        /**
         * 枚举
         */
        for (Spiciness spiciness : Spiciness.values()) {
            out.println(spiciness + " ordinal " + spiciness.ordinal());
        }

        Burrito plain = new Burrito(Spiciness.HOT);
        plain.describe();

        Burrito greenChile = new Burrito(Spiciness.MEDIUM);
        greenChile.describe();

        Burrito jalapeno = new Burrito(Spiciness.NOT);
        jalapeno.describe();

    }

    private static void f(int i, String... strings) {
        out.print(i);
        for (String s : strings) {
            out.print(s);
        }
        out.println();
    }

    private static void printMyArray(Object... objects) {
        for (Object object : objects) {
            out.println(object);
        }
    }

    private static void createElement(String s, String h) {
        out.println("s:" + s + "h:" + h);
    }

    private static void createElement(String s) {
        createElement(s, "");
    }
}

class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        out.println("This burrito is ");
        switch (degree) {
            case NOT:
                out.println("not spicy at all");
                break;
            case MILD:
            case MEDIUM:
                out.println("a little hot");
                break;
            case HOT:
            case FLAMING:
            default:
                out.println("maybe too hot");
                break;
        }
    }
}

enum Spiciness {
    NOT,
    MILD,
    MEDIUM,
    HOT,
    FLAMING
}

class A {}

class Cup {
    public Cup(int maker) {
        out.println("Cup(" + maker + ")");
    }

    void f(int maker) {
        out.println("f(" + maker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        out.println("Cups()");
    }
}

class House {
    public House() {
        out.println("house constructor");
        window3 = new Window(33);
    }

    Window window = new Window(1);
    Window window2 = new Window(2);

    void function() {
        out.println("function");
    }

    Window window3 = new Window(3);

}

class Window {
    public Window(int marker) {
        out.println("window+" + marker);
    }
}

class Counter {
    int i;

    public Counter(int i) {
        this.i = i;
    }
}

class Flower {

    Flower() {
        this("哈哈");
        out.println("Flower Constructor:none");
    }

    Flower(String seed) {
        this("哈哈哈", 34);
        out.println("Flower Constructor:seed");
    }

    Flower(String seed, int quantity) {
        out.println("Flower Constructor:seed + quantity");
    }

    void create() {
        out.println("grow flower");
    }
}

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        out.println("yao");

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
        out.println(i);
    }
}

class Tree {
    Tree() {
        out.println("Tree");
    }

    Tree(int height) {
        out.println("Tree:" + height);
    }

    public void info() {
        out.println("a small tree");
    }

    public void info(int height) {
        out.println("a big tree:" + height);
    }

    public void control(float x) {
        out.println("control:" + x);
    }

    public void control(int x) {
        out.println("control:" + x);
    }

}

class Rock {
    Rock(int i) {
        out.print("Rock " + i);
    }
}
