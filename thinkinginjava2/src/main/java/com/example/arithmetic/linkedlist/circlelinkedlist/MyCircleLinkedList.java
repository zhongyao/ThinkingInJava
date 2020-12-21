package com.example.arithmetic.linkedlist.circlelinkedlist;

import com.example.arithmetic.linkedlist.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * 环形链表相关算法
 */
public class MyCircleLinkedList {

    /**
     * 判断一个单链表是否有环：
     * 方法1
     */
    public static boolean judgeLinkedListHasLoop(Node head) {
        Node pre = head;
        Node cur = head.next;

        //定义一个栈用来存储node节点
        Stack<Node> stack = new Stack<>();
        stack.push(pre);
        stack.push(cur);
        while (cur.next != null) {
            if (!stack.contains(cur.next)) {
                //如果当前节点的下一个节点没有在该stack中，则将下一个节点push入栈，并循环下下一节点。
                stack.push(cur.next);
                cur = cur.next;
            } else {
                //如果存在，则表示之前已经存储过，已形成环状
                return true;
            }
        }
        return false;
    }

    /**
     * 判断一个单链表是否有环：
     * 方法2：
     * 声明两个指针：
     * 1、指针quick：一个指针走一次，经过两个节点（快）
     * 2、指针slow：走一次经过一个节点（慢）
     * 快指针走的比较快，若链表有环，则一定会追上慢指针，若无环，则会走到链表末端。
     */
    public static boolean judgeLinkedListHasLoop2(Node head) {
        Node quick = head;
        Node slow = head;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}
