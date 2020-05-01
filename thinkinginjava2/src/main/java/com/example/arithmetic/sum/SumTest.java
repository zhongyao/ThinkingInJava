package com.example.arithmetic.sum;

import com.example.arithmetic.linkedlist.Node;
import com.example.arithmetic.sum.bean.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 求和算法
 */
public class SumTest {


    private static int num1, num2;

    public static void main(String[] args) {

        /**
         * 两数和：
         * 给定一个整形数组和目标值，找出数组中和为目标值的两个数
         */
        int[] numArray = {2, 11, 15, 4, 6, 7};
        int targetNum = 9;
        doSum(numArray, targetNum);

        doSum2(numArray, targetNum);


        /**
         * 两数相加：
         * 给定两个非空链表表示两个非负整数。位数按照逆序方式存储，他们的每个节点只存储单个数字。将两数相加返回一个新的链表。
         */

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(3);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(4);

        doAdd(linkedList, linkedList2);

        ListNode headFirst = new ListNode(2);
        ListNode next1 = new ListNode(4);
        ListNode next2 = new ListNode(3);

        headFirst.next = next1;
        next1.next = next2;

        ListNode headSecond = new ListNode(5);
        ListNode next11 = new ListNode(6);
        ListNode next22 = new ListNode(4);

        headSecond.next = next11;
        next11.next = next22;

        ListNode node = doAdd2(headFirst, headSecond);

        printFinalHeadNode(node);
    }

    private static ListNode doAdd2(ListNode headFirst, ListNode headSecond) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = headFirst, q = headSecond, curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.value : 0;
            int y = (q != null) ? q.value : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    private static void doAdd(LinkedList<Integer> linkedList, LinkedList<Integer> linkedList2) {

        int[] tempArray = new int[linkedList.size()];
        int[] tempArray2 = new int[linkedList2.size()];
        int total;
        int total1 = 0;
        int total2 = 0;
        LinkedList<Integer> finalList = new LinkedList<>();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            tempArray[i] = (int) (linkedList.get(i) * (Math.pow(10, i)));
            total1 += tempArray[i];
        }

        for (int i = linkedList2.size() - 1; i >= 0; i--) {
            tempArray2[i] = (int) (linkedList2.get(i) * (Math.pow(10, i)));
            total2 += tempArray2[i];
        }

        total = total1 + total2;

        System.out.println("total:" + total);

        //判断当前整数的位数
        int several = (total + "").length();
        for (int i = several - 1; i >= 0; i--) {
            int num = (int) (total / Math.pow(10, i));
            finalList.add(num);
            total = (int) (total % Math.pow(10, i));
        }

        for (int i = finalList.size() - 1; i >= 0; i--) {
            System.out.println("finalList:" + finalList.get(i));
        }

    }

    private static void doSum(int[] numArray, int targetNum) {
        for (int i = 0; i < numArray.length - 1; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                int tempNum = numArray[i] + numArray[j];
                if (tempNum == targetNum) {
                    num1 = numArray[i];
                    num2 = numArray[j];
                    break;
                }
            }
        }
        System.out.println("num1:" + num1 + " num2:" + num2);
    }

    private static void doSum2(int[] numArray, int targetNum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numArray.length; i++) {
            hashMap.put(i, numArray[i]);
        }

        for (int i = 0; i < hashMap.size(); i++) {
            int element = targetNum - hashMap.get(i);
            if (hashMap.containsValue(element) && element != hashMap.get(i)) {
                num1 = hashMap.get(i);
                num2 = element;
                break;
            }
        }
        System.out.println("num1:" + num1 + " num2:" + num2);
    }

    private static void printFinalHeadNode(ListNode node) {
        if (node == null) {
            System.out.println("链表为null");
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
