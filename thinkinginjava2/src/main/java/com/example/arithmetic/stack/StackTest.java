package com.example.arithmetic.stack;

import com.example.arithmetic.stack.minstack.MyMinStack;

/**
 * Created by zhongyao on 2019-06-05.
 */
public class StackTest {
    public static void main(String[] args) {
        /**
         * 使用队列实现栈
         */

        /**
         * 使用栈实现队列
         */

        /**
         * 最小栈：
         * 设计一个支持push、pop、top操作，并能在常数时间内检索到最小元素的栈
         */
        testMinStack();
    }

    private static void testMinStack() {
        MyMinStack myMinStack = new MyMinStack();
        myMinStack.push(3);
        myMinStack.push(2);
        myMinStack.push(1);
        myMinStack.push(4);

        System.out.println(myMinStack.getStack().toString());

        print(myMinStack.getMin());
        print(myMinStack.top());

        print(myMinStack.pop());
        print(myMinStack.pop());
        print(myMinStack.pop());
        print(myMinStack.pop());
    }

    private static void print(int num) {
        System.out.println("---" + num);
    }
}
