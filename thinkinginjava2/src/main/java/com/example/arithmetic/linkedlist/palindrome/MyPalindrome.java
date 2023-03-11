package com.example.arithmetic.linkedlist.palindrome;

import com.example.arithmetic.linkedlist.Node;
import com.example.arithmetic.linkedlist.reverse.MyListReverse;

import java.util.Scanner;
import java.util.Stack;

/**
 * 判断一个链表是否是回文链表
 */
public class MyPalindrome {

    /**
     * 方法一：
     * 借助Stack，先让所有的链表节点按顺序入栈，然后出栈跟原链表的节点一个个对比，如果均相等，则为回文链表
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome_One(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp.data != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法二：
     * 借助Stack，将前半部分的链表节点按顺序入栈，然后出栈跟剩余的链表节点按顺序一个个做对比
     *
     * @param head
     */
    public static boolean isPalindrome_Two(Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        int count = 0;
        //将节点入栈，并计算链表长度
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
            count++;
        }
        //求链表一半的长度：右移一位并复制【相当于count = count/2;】但效率更高
        count >>= 1;
        //将链表前半部分的节点跟栈中的节点一个个做对比
        while (count >= 0) {
            temp = stack.pop();
            if (temp.data != head.data) {
                return false;
            }
            head = head.next;
            count--;
        }
        return true;
    }

    /**
     * 方法三：反转后半部分链表【快慢指针】
     * (1)先使用快慢双指针的方式，找到链表的中间节点
     * (2)然后将链表后半部分进行反转
     * (3)重置快指针【至头结点且一次走一步】，将快慢指针走过的节点一一进行对比，直至重合
     *
     * @param head
     */
    public static boolean isPalindrome_Three(Node head) {
        Node fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }

        //反转后半部分链表
        slow = MyListReverse.doReverse(slow);
        //重置快指针
        fast = head;
        //将快慢指针都过的节点一一对比【当前快指针一次走一步】
        while (slow != null) {
            if (fast.data != slow.data) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
