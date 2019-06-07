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

    }

    public void postOrder(Node head) {

    }

    private void print(String value) {
        System.out.print(value + " ");
    }
}
