package com.example;

import static java.lang.System.out;

/**
 * @author zhongyao
 * @date 2018/1/16
 */

public class Chapter7ReusingClass extends Cleaner {
    private String value1, value2;
    //private WaterSource source = new WaterSource();
    private int i;
    private float f;

    /**
     * 1、每个非基本类型的对象都有一个toString()方法，而且当编译器需要一个String而你却只有一个对象时，该方法便会被调用。
     * 2、类中域为基本类型时能够自动初始化为零，但是对象引用会被初始化为null
     *
     * @return
     */
    //@Override
    //public String toString() {
        //return "value1=" + value1 + " value2=" + value2 + " i:" + i + " f:" + f + " source:" + source;
    //}

    @Override
    public void scrub() {
        append("Chapter.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    public static void main(String[] args) {
        //Chapter7ReusingClass reusingClass = new Chapter7ReusingClass();
        //out.println(reusingClass);
        Chapter7ReusingClass chapter = new Chapter7ReusingClass();
        chapter.dilute();
        chapter.apply();
        chapter.scrub();
        chapter.foam();
        out.println(chapter);
        out.println("Testing base class");
        Cleaner.main(args);

    }
}

//class WaterSource {
//    private String s;
//
//    public WaterSource() {
//        out.println("WaterSource");
//        s = "Constructed";
//    }
//
//    @Override
//    public String toString() {
//        return s;
//    }
//}

class Cleaner {
    private String s = "Cleaner";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleaner x = new Cleaner();
        x.dilute();
        x.apply();
        x.scrub();

        out.println(x);
    }
}