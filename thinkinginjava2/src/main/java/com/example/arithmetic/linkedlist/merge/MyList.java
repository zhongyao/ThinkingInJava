package com.example.arithmetic.linkedlist.merge;

import com.example.arithmetic.linkedlist.Node;

/**
 * Created by zhongyao on 2019-06-03.
 * 合并两个有序链表
 */
public class MyList {

    /**
     * 非递归方式
     */
    public static Node doMerge(Node head1, Node head2) {

        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        //合并后单链表节点
        Node head = head1.data < head2.data ? head1 : head2;

        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;

        //cur1的前一个元素
        Node pre = null;
        //cur2的后一个元素
        Node next = null;

        while (cur1 != null && cur2 != null) {
            //第一次进来肯定走这里
            if (cur1.data <= cur2.data) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    /**
     * 递归法
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node doRecursionMerge(Node head1, Node head2) {
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
            head.next = doRecursionMerge(head1.next, head2);
        } else {
            head = head2;
            head.next = doRecursionMerge(head1, head2.next);
        }
        return head;
    }
}
