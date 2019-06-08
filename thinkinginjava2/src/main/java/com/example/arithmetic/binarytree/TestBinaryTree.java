package com.example.arithmetic.binarytree;

import com.example.arithmetic.binarytree.order.BTOrder;
import com.example.arithmetic.binarytree.recursionorder.BTRecursionOrder;

/**
 * Created by zhongyao on 2019-06-08.
 */
public class TestBinaryTree {
    public static void main(String[] args) {

        /**
         * 递归实现：
         * 先序遍历
         * 中序遍历
         * 后续遍历
         */
        testBTRecursionOrder();
        println();

        /**
         * 非递归实现：
         * 前序遍历
         * 中序遍历
         * 后序遍历
         */
        testBTOrder();
    }

    private static void testBTOrder() {
        BTOrder order = new BTOrder();

        Node nodeG = new Node("G", null, null);
        Node nodeA = new Node("A", null, null);
        Node nodeF = new Node("F", null, null);
        Node nodeN = new Node("N", null, null);

        Node nodeC = new Node("C", nodeG, null);
        Node nodeI = new Node("I", null, nodeA);

        Node nodeB = new Node("B", nodeC, nodeF);
        Node nodeE = new Node("E", nodeI, nodeN);

        Node nodeD = new Node("D", nodeB, nodeE);

        order.preOrder(nodeD);
        println();
        order.inOrder(nodeD);
        println();
        order.postOrder(nodeD);
    }

    private static void testBTRecursionOrder() {
        BTRecursionOrder recursionOrder = new BTRecursionOrder();

        Node nodeG = new Node("G", null, null);
        Node nodeA = new Node("A", null, null);
        Node nodeF = new Node("F", null, null);
        Node nodeN = new Node("N", null, null);

        Node nodeC = new Node("C", nodeG, null);
        Node nodeI = new Node("I", null, nodeA);

        Node nodeB = new Node("B", nodeC, nodeF);
        Node nodeE = new Node("E", nodeI, nodeN);

        Node nodeD = new Node("D", nodeB, nodeE);

        recursionOrder.preOrderRecursion(nodeD);
        println();
        recursionOrder.inOrderRecursion(nodeD);
        println();
        recursionOrder.postOrderRecursion(nodeD);
        println();

    }

    private static void println() {
        System.out.println();
    }
}