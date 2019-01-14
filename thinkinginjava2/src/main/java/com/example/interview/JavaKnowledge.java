package com.example.interview;

import java.util.HashMap;

/**
 * @author zhongyao
 * @date 2019/1/14
 */

public class JavaKnowledge {
    public static void main(String args[]) {
        /**
         * 1、"=="与"equals":
         * "=="如果是基本值类型，表示值是否相同；如果是对象表示对象地址是否相同
         * "equals"表示两个对象的内容是否相同
         */
        //String a = "hello";
        //String b = "hello";

        int i = 2;
        int j = 2;
        HashMap<String,String> hashMap = new HashMap<>();
        String a = new String("hello");
        String b = new String("hello");
        //out(a == b);//true
        out(a == b);//false
        out(a.equals(b));//ture
        out(a.hashCode());
        out(b.hashCode());
        out(i == j);

    }

    private static void out(boolean result) {
        System.out.println(result);
    }

    private static void out(int string) {
        System.out.println(string);
    }

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
