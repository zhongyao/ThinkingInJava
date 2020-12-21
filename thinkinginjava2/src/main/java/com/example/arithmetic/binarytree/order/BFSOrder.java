package com.example.arithmetic.binarytree.order;

import com.example.arithmetic.binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历【广度优先遍历，即层次遍历】
 */
public class BFSOrder {

    public void levelTraversal(Node root){
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

    private void print(String value) {
        System.out.print(value + " ");
    }
}
