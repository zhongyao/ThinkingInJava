package com.example.arithmetic.linkedlist.reverse;

import com.example.arithmetic.linkedlist.Node;

/**
 * Created by zhongyao on 2019-06-04.
 * 单链表反转
 * 思路：
 */
public class MyListReverse {

    /**
     * 遍历反转法：
     * 从前往后反转各个节点的指针域指向
     *
     * @param head
     * @return
     */
    public static Node doReverse(Node head) {

        if (head == null) {
            return null;
        }
        //上一节点
        Node pre = head;
        //当前节点
        Node cur = head.next;
        //临时节点，用于保存当前节点的指针域（即下一个节点）
        Node temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        head.next = null;

        return pre;
    }

    /**
     * 递归反转法：
     * 从后往前反转各个节点的指针域指向
     *
     * @param head
     * @return
     */
    public static Node doRecursionReverse(Node head) {
        if (head == null) {
            return null;
        }

        return null;
    }
}
