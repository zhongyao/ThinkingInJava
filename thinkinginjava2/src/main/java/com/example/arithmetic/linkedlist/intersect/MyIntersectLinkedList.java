package com.example.arithmetic.linkedlist.intersect;

import com.example.arithmetic.linkedlist.Node;

import java.util.HashSet;

/**
 * 2个单项链表查重
 * 【找到两个链表相交的起始节点】
 */
public class MyIntersectLinkedList {

    /**
     * 方法1：
     * 使用HashSet查重
     * <p>
     * 思路：
     * 首先将第一个链表放置HashSet中
     * 然后，判断第二个链表中的元素，在HashSet中是否有包含的项，
     * 如果有的话，则表示有相交，那么就返回该节点
     */
    public static Node doIntersect(Node nodeA, Node nodeB) {
        HashSet<Node> hashSet = new HashSet<>();

        while (nodeA != null) {
            hashSet.add(nodeA);
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            if (hashSet.contains(nodeB)) {
                return nodeB;
            } else {
                nodeB = nodeB.next;
            }
        }
        return null;
    }

    /**
     * 方法2：
     * 双指针--拼接链表--思维
     * 思路：
     * 有关长度，A+B = B+A
     * 当A遍历完去遍历B，B遍历完去遍历A
     * 俩指针都遍历一次A、B后，就是交点，若无交点，两者在末尾指向null
     *
     * @param headA
     * @param headB
     * @return
     */
    public static Node doIntersect2(Node headA, Node headB) {
        Node A = headA;
        Node B = headB;
        // 两指针未相遇，循环
        while (A != B) {
            // 指针1移动
            if (A == null) {
                // 必须遍历到null再换B遍历，这样AB各一遍就结束了（同指向null，表明没有交点）。如果遍历到A末尾就直接换B，导致不停的ABAB循环多次
                A = headB;
            } else {
                A = A.next;
            }
            // 指针2移动
            if (B == null) {
                B = headA;
            } else {
                B = B.next;
            }
        }
        return A;
    }
}
