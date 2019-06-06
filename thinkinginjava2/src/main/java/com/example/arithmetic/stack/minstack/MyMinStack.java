package com.example.arithmetic.stack.minstack;

import java.util.Stack;

/**
 * Created by zhongyao on 2019-06-05.
 */
public class MyMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MyMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty() || minStack.peek() >= number) {
            minStack.push(number);
        }

    }

    public int pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public Stack<Integer> getStack() {
        return stack;
    }
}
