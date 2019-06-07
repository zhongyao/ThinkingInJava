package com.example.arithmetic.binarytree;

/**
 * Created by zhongyao on 2019-06-08.
 * 二叉树节点
 */
public class Node {
    public String value;
    public Node left;
    public Node right;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
