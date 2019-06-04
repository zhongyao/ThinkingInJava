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
     * (在反转当前节点之前先反转后续节点)
     *
     * @param head
     * @return
     */
    public static Node doRecursionReverse(Node head) {
        //head看做是前一节点，head.next 看作是当前节点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            //若为空链表或者当前节点在尾节点，直接返回
            return head;
        }

        //先反转后续节点head.next
        Node reHead = doRecursionReverse(head.next);
        //将当前节点的指针域指向前一节点(注：head.next看作是当前节点)
        head.next.next = head;
        //将前一节点的指针域置空(注：head看作是前一节点)
        head.next = null;

        return reHead;
    }
}
