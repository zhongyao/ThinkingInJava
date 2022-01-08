package com.example.arithmetic.binarytree.recursionorder;

import com.example.arithmetic.binarytree.Node;

/**
 * Created by zhongyao on 2019-06-08.
 * 递归：二叉树遍历
 */
public class BTRecursionOrder {

    public void preOrderRecursion(Node head) {
        if (head == null) {
            return;
        }

        print(head.value);
        preOrderRecursion(head.left);
        preOrderRecursion(head.right);
    }

    public void inOrderRecursion(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecursion(head.left);
        print(head.value);
        inOrderRecursion(head.right);
    }

    public void postOrderRecursion(Node head) {
        if (head == null) {
            return;
        }

        postOrderRecursion(head.left);
        postOrderRecursion(head.right);
        print(head.value);
    }

    private void print(String string) {
        System.out.print(string + " ");
    }
}
