package com.example.arithmetic.linkedlist;

import java.util.ArrayList;

import com.example.arithmetic.linkedlist.delete.MyListRemove;
import com.example.arithmetic.linkedlist.insert.MyInsertList;
import com.example.arithmetic.linkedlist.merge.MyList;

/**
 * Created by zhongyao on 2019-06-03.
 * 链表相关算法
 *
 * algorithm  [ˈælɡərɪðəm] 算法
 */
public class LinkedListAlgorithm {
    public static void main(String[] args) {

        /**
         * 删除无序单链表中重复的节点
         */
        testRemoveRepeatNode();

        /**
         * 向有序的环形单链表中插入新节点
         */
        //testInsertNode();

        /**
         * 删除链表中某个指定节点(非末端节点)
         */
        //testRemoveNode();

        /**
         * 删除链表中某个值的节点
         * 1 2 6 3 4 5 6
         * 删除value值为6的所有节点:
         * 1 2 3 4 5
         */
        //testRemove();
        //testRemoveWithStack();

        /**
         * 两个有序链表
         * 1 3 6 7
         * 2 4 5 9
         * 合并成一个有序链表
         * 1 2 3 4 5 6 7 9
         */
        //遍历合并
        //testMerge();
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

    private static void testRemoveRepeatNode() {
        Node head = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node resultHead = MyListRemove.doRemoveRepeatNode(head);
        printLinkedList(resultHead);
    }

    private static void testInsertNode() {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node newNode = new Node(5);

        Node headRet = MyInsertList.doInsertNode(head, newNode);
        printLinkedList(headRet);

    }

    private static void testRemoveNode() {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        MyListRemove.doRemoveNode(node2);

        printLinkedList(head);
    }

    private static void testRemoveWithStack() {
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

        Node deletedHead = MyListRemove.doRemoveWithStack(head, 6);
        printLinkedList(deletedHead);
    }

    private static void testRemove() {
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

        Node deletedHead = MyListRemove.doRemove(head, 6);
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

        Node reverseHead = com.example.arithmetic.linkedlist.reverse.MyListRemove.doRecursionReverse(head);
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

        Node reverseHead = com.example.arithmetic.linkedlist.reverse.MyListRemove.doReverse(head);
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
