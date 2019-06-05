package com.example.arithmetic.linkedlist.delete;

import com.example.arithmetic.linkedlist.Node;

/**
 * Created by zhongyao on 2019-06-05.
 */
public class MyListDelete {

    public static Node doDelete(Node head, int value) {
        //从链表头开始，找到一个值不等于value的节点，作为新的节点。
        while (head != null) {
            if (head.data != value) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.data == value) {
                //如果此节点等于value，则将该节点删除，删除方式是将pre的next指向cur.next节点
                pre.next = cur.next;
            } else {
                //如果此节点不等于value，则将该节点后移
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
