package com.example.arithmetic.stack;

import com.example.arithmetic.stack.minstack.MyMinStack;
import com.example.arithmetic.stack.minstack.MyMinStack2;
import com.example.arithmetic.stack.queuewithstack.MyQueueWithStack;

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
        //testMinStack();

        /**
         * 编写一个类，用两个栈实现队列，支持队列的基本操作（add poll peek）
         */
        //testQueueWithStack();

        /**
         * 设计一个具有获取min功能的栈
         */

        testMinStack2();
    }

    private static void testMinStack2() {
        MyMinStack2 minStack2 = new MyMinStack2();
        minStack2.push(3);
        minStack2.push(2);
        minStack2.push(1);
        minStack2.push(4);

        print(minStack2.getMin());

        minStack2.pop();
        minStack2.pop();
        minStack2.pop();
        minStack2.pop();

        print(minStack2.getMin());

    }

    private static void testQueueWithStack() {
        MyQueueWithStack queueWithStack = new MyQueueWithStack();
        queueWithStack.push(3);
        queueWithStack.push(2);
        queueWithStack.push(1);
        queueWithStack.push(4);

        print(queueWithStack.poll());
        print(queueWithStack.poll());
        print(queueWithStack.poll());
        print(queueWithStack.poll());

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
