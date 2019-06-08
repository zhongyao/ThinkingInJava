package com.example.arithmetic.linkedlist.delete;

import java.util.HashSet;
import java.util.Stack;

import com.example.arithmetic.linkedlist.Node;

/**
 * Created by zhongyao on 2019-06-05.
 */
public class MyListRemove {

    /**
     * 删除无序单链表中值重复的节点
     * 方法2：类似于选择排序
     */
    public static Node doRemoveRepeatNode2(Node head) {
        Node cur = head;
        Node pre;
        Node next;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.data == next.data) {
                    pre.next = next.next;
                }else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除无序单链表中值重复出现的节点
     * 方法1：利用哈希表
     */
    public static Node doRemoveRepeatNode1(Node head) {
        Node pre;
        Node cur;
        if (head == null) {
            return null;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.data);

        pre = head;
        cur = head.next;
        while (cur != null) {
            if (hashSet.contains(cur.data)) {
                pre.next = cur.next;
            } else {
                hashSet.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }

        return head;

    }

    /**
     * 删除链表中给定的节点(非末尾节点)
     */
    public static void doRemoveNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    /**
     * 删除链表中所有值为value的节点
     *
     * @param head
     * @param value
     * @return
     */
    public static Node doRemove(Node head, int value) {
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

    /**
     * 借助于栈--删除链表中所有值为value的节点
     * 思路：
     * 首先将所有节点值不等于value的节点顺序入栈，然后出栈连接即可。
     *
     * @param head
     * @param value
     * @return
     */
    public static Node doRemoveWithStack(Node head, int value) {
        Stack<Node> stack = new Stack<>();

        while (head != null) {
            if (head.data != value) {
                stack.push(head);
            }
            head = head.next;
        }

        //将栈底的节点作为新的头结点返回。
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }
}
