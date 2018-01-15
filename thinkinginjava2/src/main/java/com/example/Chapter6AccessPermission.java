package com.example;

/**
 * @author zhongyao
 * @date 2018/1/15
 * 访问权限控制：
 *
 * 1、类只能是public或默认的包访问权限，不能使用private或protected（内部类除外）
 *
 * 2、无论在什么样的关系之中，设立一些为各成员所遵守的界限始终是很重要的
 *
 * 3、控制对成员的访问权限有两个原因：
 *    1>为了使用户不要触碰哪些他们不应该触碰的部分，这些部门对于内部的操作是必要的，但是他并不属于客户端程序员接口的一部分
 *    2>也是最重要的一部分，是为了让类库设计者可以更改类的内部工作方式，而不必担心这样会对客户端程序员产生重大的影响
 */

public class Chapter6AccessPermission {
    public static void main(String[] args) {

        Soup1.makeSoup();
        //无法使用这种方式来生成对象
        //Soup1 soup1 = new Soup1();
        //单例
        Soup2.makeSoup();
    }

}

class Soup1 {
    private Soup1() {}

    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {}

    public static Soup2 soup2 = new Soup2();

    public static Soup2 makeSoup() {
        return soup2;
    }
}