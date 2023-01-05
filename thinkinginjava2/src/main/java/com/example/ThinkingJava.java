package com.example;

import com.example.arithmetic.linkedlist.Node;
import com.example.util.NumberUtil;

import java.util.Stack;


public class ThinkingJava {
    public static void main(String args[]) {
        //正确输出：35425368 79605238
        String string = "三千五百四十二万五千三百六十八亿七千九百六十万零五千二百三十八";
        long result = NumberUtil.chineseToNum(string);
        System.out.println("result:" + result);

        //1
        //2
    }
    private Node doChange(Node head) {
        Stack<Node> stack = new Stack<>();
        Node fast = head;
        Node slow = head;

        //定义链表中点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //后半部分链表入栈
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        //重组链表
        Node pre = head;
        Node cur = head.next;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            pre.next = node;
            node.next = cur;
            pre = cur;
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    //3
}
