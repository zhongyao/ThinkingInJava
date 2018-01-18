package com.example.chapter7;

import static java.lang.System.out;

/**
 * @author zhongyao
 * @date 2018/1/18
 */

public class Drawing extends Art {
    public Drawing() {
        out.println("Drawing constructor");
    }

    public Drawing(int i) {
        super(i);
        out.println("Drawing constructor" + i);
    }
}
