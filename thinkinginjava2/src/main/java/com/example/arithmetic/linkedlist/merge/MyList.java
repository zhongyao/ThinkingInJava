package com.example.arithmetic.linkedlist.merge;

import com.example.arithmetic.linkedlist.Node;

/**
 * Created by zhongyao on 2019-06-03.
 * 合并两个有序链表
 */
public class MyList {
    /**
     * 递归法
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeTwoLinkedList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node head;
        if (head1.data <= head2.data) {
            head = head1;
            head.next = mergeTwoLinkedList(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeTwoLinkedList(head1, head2.next);
        }
        return head;
    }
}
