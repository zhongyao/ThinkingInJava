package com.example.arithmetic.linkedlist;

import java.util.ArrayList;

import com.example.arithmetic.linkedlist.merge.MyList;
import com.example.arithmetic.linkedlist.merge.Node;

/**
 * Created by zhongyao on 2019-06-03.
 * 链表相关算法
 *
 * algorithm  [ˈælɡərɪðəm] 算法
 */
public class LinkedListAlgorithm {
    public static void main(String[] args) {
        /**
         * 两个有序链表
         * 1 3 6 7
         * 2 4 5 9
         * 合并成一个有序链表
         */
        testLinkedListMerge();
    }

    private static void testLinkedListMerge() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node node5 = new Node(2);
        Node node6 = new Node(4);
        Node node7 = new Node(5);
        Node node8 = new Node(9);

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Node node = MyList.mergeTwoLinkedList(node1, node5);

        printMergedHeadNode(node);
    }

    private static void printMergedHeadNode(Node node) {

        if (node == null) {
            System.out.println("链表为null");
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + ",");
        }
    }
}
