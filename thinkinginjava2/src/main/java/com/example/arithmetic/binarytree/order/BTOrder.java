package com.example.arithmetic.binarytree.order;

import java.util.Stack;

import com.example.arithmetic.binarytree.Node;

/**
 * Created by zhongyao on 2019-06-08.
 */
public class BTOrder {

    private Stack<Node> stack = new Stack<>();

    public void preOrder(Node head) {
        stack.push(head);
        while (!stack.empty()) {
            Node cur = stack.pop();
            print(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder(Node head) {
        if (head != null) {
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    print(head.value);
                    head = head.right;
                }
            }
        }
    }

    /**
     * 只是用一个栈实现后序遍历的算法:
     *
     * @param head
     */
    public void postOrder1(Node head) {
        if (head != null) {
            stack.push(head);
            Node c;
            while (!stack.empty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    print(stack.pop().value);
                    head = c;
                }
            }
        }
    }

    /**
     * 使用两个栈实现后序遍历算法
     *
     * @param head
     */
    public void postOrder2(Node head) {
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();

            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                if (head.left != null) {
                    stack1.push(head.left);
                }

                if (head.right != null) {
                    stack1.push(head.right);
                }

                stack2.push(head);
            }

            while (!stack2.empty()) {
                print(stack2.pop().value);
            }

        }
    }

    private void print(String value) {
        System.out.print(value + " ");
    }
}
