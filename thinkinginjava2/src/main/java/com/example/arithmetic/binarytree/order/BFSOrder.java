package com.example.arithmetic.binarytree.order;

import com.example.arithmetic.binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历【广度优先遍历，即层次遍历】
 */
public class BFSOrder {

    /**
     * 层次遍历
     *
     * @param root
     */
    public void levelTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            print(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * S型层次遍历
     * <p>
     * 思路：
     * 遍历奇数层的Node时，从右至左将其孩子进 偶数层栈
     * 遍历偶数层的Mode时，从左至右将其孩子进 奇数层栈
     *
     * @param root
     */
    public void levelTraversal_S(Node root) {
        //奇数层栈
        Stack<Node> oddStack = new Stack<>();
        //偶数层栈
        Stack<Node> evenStack = new Stack<>();

        oddStack.push(root);

        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (!oddStack.isEmpty()) {
                while (!oddStack.isEmpty()) {
                    Node node = oddStack.pop();
                    print(node.value);

                    if (node.right != null) {
                        evenStack.push(node.right);
                    }

                    if (node.left != null) {
                        evenStack.push(node.left);
                    }
                }
            } else {
                while (!evenStack.isEmpty()) {
                    Node node = evenStack.pop();
                    print(node.value);

                    if (node.left != null) {
                        oddStack.push(node.left);
                    }

                    if (node.right != null) {
                        oddStack.push(node.right);
                    }
                }
            }
        }
    }

    private void print(String value) {
        System.out.print(value + " ");
    }
}
