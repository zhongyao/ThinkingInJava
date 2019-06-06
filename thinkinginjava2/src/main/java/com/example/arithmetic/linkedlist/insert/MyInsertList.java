package com.example.arithmetic.linkedlist.insert;

import com.example.arithmetic.linkedlist.Node;

/**
 * Created by zhongyao on 2019-06-06.
 */
public class MyInsertList {

    /**
     * 向有序链表中插入一个节点，插入之后的链表依然是有序链表
     *
     * @param head
     * @param newNode
     */
    public static Node doInsertNode(Node head, Node newNode) {
        if (head.data > newNode.data) {
            newNode.next = head;
            return newNode;
        }

        Node headRet = head;
        Node pre = null;
        Node next = head.next;
        while (next.data <= newNode.data) {
            pre = next;
            next = next.next;

            if (next == null) {
                //已走到最后节点
                pre.next = newNode;
                return headRet;
            }
        }

        if (next.next != null) {
            newNode.next = next;
            pre.next = newNode;
        } else {
            next.next = newNode;
        }
        return headRet;
    }
}
