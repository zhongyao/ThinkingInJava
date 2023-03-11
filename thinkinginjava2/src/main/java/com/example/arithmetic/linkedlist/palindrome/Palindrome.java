package com.example.arithmetic.linkedlist.palindrome;

import com.example.arithmetic.sum.bean.ListNode;

import java.util.Stack;

/**
 * 回文链表
 */
public class Palindrome {

    /**
     * 判断当前链表是否是回文链表
     * 输入：head = [1,2,2,1]
     * 输出：true
     *
     * 【方法1：借助Stack】
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while(head != null) {
            if(head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 判断当前链表是否是回文链表
     *
     * 【方法2：借助Stack】
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {


    }

}
