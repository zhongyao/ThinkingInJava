package com.example.arithmetic.stack.minstack;

import java.util.Stack;

/**
 * Created by zhongyao on 2019-06-06.
 */
public class MyMinStack2 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        stack.push(num);
        if (minStack.empty()) {
            minStack.push(num);
        } else {
            if (num <= minStack.peek()) {
                minStack.push(num);
            }
        }
    }

    public int pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int peek() {
        if (stack.empty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.empty()) {
            throw new RuntimeException("minStack is empty");
        }
        return minStack.pop();
    }
}
