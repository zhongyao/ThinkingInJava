package com.example.arithmetic.linkedlist;

import java.util.ArrayList;

import com.example.arithmetic.linkedlist.delete.MyListDelete;
import com.example.arithmetic.linkedlist.merge.MyList;
import com.example.arithmetic.linkedlist.reverse.MyListReverse;

/**
 * Created by zhongyao on 2019-06-03.
 * 链表相关算法
 *
 * algorithm  [ˈælɡərɪðəm] 算法
 */
public class LinkedListAlgorithm {
    public static void main(String[] args) {

        /**
         * 删除链表中某个值的节点
         * 1 2 6 3 4 5 6
         * 删除value值为6的所有节点:
         * 1 2 3 4 5
         */
        testDelete();

        /**
         * 两个有序链表
         * 1 3 6 7
         * 2 4 5 9
         * 合并成一个有序链表
         * 1 2 3 4 5 6 7 9
         */
        //遍历合并
        testMerge();
        //递归合并
        //testRecursionMerge();

        /**
         * 单链表
         * 2 3 5 4
         * 反转
         * 4 5 3 2
         */
        //遍历反转法
        //testLinkedListReverse();
        //递归反转法
        //doRecursionReverse();
    }

    private static void testDelete() {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(6);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node deletedHead = MyListDelete.doDelete(head, 6);
        printLinkedList(deletedHead);

    }

    private static void testMerge() {
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

        Node node = MyList.doMerge(node1, node5);

        printMergedHeadNode(node);
    }

    private static void doRecursionReverse() {
        Node head = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        //打印反转前的链表
        printLinkedList(head);

        Node reverseHead = MyListReverse.doRecursionReverse(head);
        //打印反转后的链表
        printLinkedList(reverseHead);

    }

    private static void testLinkedListReverse() {
        Node head = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        //打印反转前的链表
        printLinkedList(head);

        Node reverseHead = MyListReverse.doReverse(head);
        //打印反转后的链表
        printLinkedList(reverseHead);
    }

    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static void testRecursionMerge() {
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

        Node node = MyList.doRecursionMerge(node1, node5);

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
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
