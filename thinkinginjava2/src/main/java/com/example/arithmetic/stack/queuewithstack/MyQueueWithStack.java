package com.example.arithmetic.stack.queuewithstack;

import java.util.Stack;

/**
 * Created by zhongyao on 2019-06-06.
 * 思路：
 * 1、先将元素入栈(stackPush)
 * 2、获取元素时需将栈(stackPush)中的元素逐个出栈然后push到栈（stackPop）中
 * 3、stackPop元素出栈获取元素
 */
public class MyQueueWithStack {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public MyQueueWithStack() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int num) {
        stackPush.push(num);
    }

    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
