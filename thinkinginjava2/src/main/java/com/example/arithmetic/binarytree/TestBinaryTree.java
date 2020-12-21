package com.example.arithmetic.binarytree;

import com.example.arithmetic.binarytree.order.BFSOrder;
import com.example.arithmetic.binarytree.order.DFSOrder;
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


        /**
         * 广度优先遍历【层次遍历】
         */
        testBFSOrder();
    }

    private static void testBFSOrder() {
        BFSOrder order = new BFSOrder();

        Node nodeG = new Node("G", null, null);
        Node nodeA = new Node("A", null, null);
        Node nodeF = new Node("F", null, null);
        Node nodeN = new Node("N", null, null);

        Node nodeC = new Node("C", nodeG, null);
        Node nodeI = new Node("I", null, nodeA);

        Node nodeB = new Node("B", nodeC, nodeF);
        Node nodeE = new Node("E", nodeI, nodeN);

        Node nodeD = new Node("D", nodeB, nodeE);

        println();
        println();
        println("广度优先遍历：");
        order.levelTraversal(nodeD);
    }

    private static void testBTOrder() {
        DFSOrder order = new DFSOrder();

        Node nodeG = new Node("G", null, null);
        Node nodeA = new Node("A", null, null);
        Node nodeF = new Node("F", null, null);
        Node nodeN = new Node("N", null, null);

        Node nodeC = new Node("C", nodeG, null);
        Node nodeI = new Node("I", null, nodeA);

        Node nodeB = new Node("B", nodeC, nodeF);
        Node nodeE = new Node("E", nodeI, nodeN);

        Node nodeD = new Node("D", nodeB, nodeE);

        order.preOrderTraversal(nodeD);
        println();
        order.preOrderTraversal2(nodeD);
        println();
        order.inOrderTraversal(nodeD);
        println();
        order.inOrderTraversal2(nodeD);
        println();
        order.postOrderTraversal(nodeD);
        println();
        order.postOrder1(nodeD);
        println();
        order.postOrder2(nodeD);
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

    private static void println(String string) {
        System.out.println("---" + string);
    }
}
