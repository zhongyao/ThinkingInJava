package com.example.interview;

import java.util.HashMap;

/**
 * @author zhongyao
 * @date 2019/1/14
 */

public class JavaKnowledge {
    public static void main(String args[]) {
        /**
         * 一、"=="与"equals":
         * "=="如果是基本值类型，表示值是否相同；如果是对象表示对象地址是否相同
         * "equals"表示两个对象的内容是否相同
         */
        //String a = "hello";
        //String b = "hello";

        int i = 2;
        int j = 2;
        HashMap<String, String> hashMap = new HashMap<>();
        String a = new String("hello");
        String b = new String("hello");
        //out(a == b);//true
        out(a == b);//false
        out(a.equals(b));//ture
        out(a.hashCode());
        out(b.hashCode());
        out(i == j);

        /**
         * 三、wait()与sleep()的区别：
         * 1、wait()会释放对象锁，直到调用notify()方法
         * 2、而sleep()不会释放对象锁
         */

        /**
         * 四、String str = new String("abc");
         * String str = "abc";的区别:
         *
         * 第一个是创建了两个对象:一个"abc"对象 一个new String("abc")产生的对象
         * 第二个是创建了一个对象
         */
        String str = new String("abc");
        String str2 = "abc";
        out(str.equals(str2));
        out(str == str2);

        /**
         * 五、如何用String str1 = "abc"，String str2 = "def"，String str3 = "ghi"得到"abcdefghi"字符串？
         * 如果使用String str = str1+str2+str3的方式，不是一个好的方式，因为在字符串常量池中会产生不必要的字符串
         * 最好的方式是使用StringBuilder
         *
         * String StringBuffer StringBuilder的区别：
         * String是字符串常量
         * StringBuffer是字符串变量（线程安全）
         * StringBuilder是字符串变量（非线程安全）
         */
        StringBuilder builder = new StringBuilder();
        builder.append("abc");
        builder.append("def");
        builder.append("ghi");
        out(builder.toString());

        /**
         * 六、HashMap、HashTable、ConcurrentHashMap、SynchronisedMap的区别：
         * HashMap是非线程安全的
         * HashTable、ConcurrentHashMap、SynchronisedMap是线程安全的
         *
         * HashTable中是使用synchronised来保证线程安全的
         * ConcurrentHashMap是Java并发包中提供的一个线程安全且高效的HashMap实现，采用了非常精妙的"分段锁"策略，ConcurrentHashMap的主干是个Segment数组。
         *ConcurrentHashMap性能是明显优于Hashtable和SynchronizedMap的,ConcurrentHashMap花费的时间比前两个的一半还少
         *
         */

        /**
         * 七、volatile关键字的含义：
         * 1、保证了不同线程对这个变量操作的可见性，即一个线程修改了变量的值，这个新值对其他线程来说是可见的
         * 2、禁止进行指令重排序
         */

    }

    private static void out(String string) {
        System.out.println(string);
    }

    private static void out(boolean result) {
        System.out.println(result);
    }

    private static void out(int string) {
        System.out.println(string);
    }

    /**
     * 二、hashCode与equals的区别：
     */
    /**
     * 是对两个对象的地址值进行的比较（即比较引用是否相同）
     *
     * equals相等的两个对象，hashCode肯定相等
     * 但hashCode相等的两个对象，equals不一定相等
     *
     * 可以考虑在集合中，判断两个对象是否相等的规则：
     * 1、如果两者的hashCode()相等，则查看第二步,否则就是不相等
     * 2、查看equals()是否相等，如果相等，则量obj相等，否则还是不相等
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * 是一个本地方法，它的实现是根据本地机器相关的
     *
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
