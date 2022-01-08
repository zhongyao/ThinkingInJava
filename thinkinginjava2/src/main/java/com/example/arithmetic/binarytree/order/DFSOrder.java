package com.example.arithmetic.binarytree.order;

import java.util.Stack;

import com.example.arithmetic.binarytree.Node;

import javax.swing.tree.TreeNode;

/**
 * Created by zhongyao on 2019-06-08.
 * 参考：https://www.jianshu.com/p/456af5480cee
 * 二叉树遍历【深度优先遍历】：
 * 数据结构--栈：
 * 父节点入栈，父节点出栈，先右子节点入栈，后左子节点出栈。递归遍历所有节点即可。
 */
public class DFSOrder {

    /**
     * 先序遍历：
     * 因为要在遍历完节点的左子树后接着遍历节点的右子树，为了能够找到节点，需要使用栈来进行暂存。
     *
     * @param root
     */
    public void preOrderTraversal(Node root) {
        //用来存储节点的栈
        Stack<Node> stack = new Stack<>();
        //新建一个游标节点为根节点
        Node node = root;
        //当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空。
        //所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !stack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                print(node.value);
                // 为了之后能找到该节点的右子树，暂存该节点
                stack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void preOrderTraversal2(Node root) {
        if (root != null) {
            //用来存储节点的栈
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            //循环--如果栈不为空，则进行后续操作
            while (!stack.empty()) {
                //出栈
                Node cur = stack.pop();
                //***打印节点***
                print(cur.value);
                //右节点不为空，则入栈
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                //左节点不为空，则入栈
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                print(node.value);
                node = node.right;
            }
        }
    }


    public void inOrderTraversal2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        if (node != null) {
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    print(node.value);
                    node = node.right;
                }
            }
        }
    }

    /**
     * 后续遍历
     * @param root
     */
    public void postOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            //将左边所有的节点入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = stack.peek();
            //如果右节点也为空，或者右节点等于最后一次访问的节点，那么输出当前节点
            //并且出栈，赋值为lastVisit，最后置空
            if (node.right == null || node.right == lastVisit) {
                print(node.value);
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历--方法1：
     * 只是用一个栈实现后序遍历的算法:
     *
     * @param root
     */
    public void postOrder1(Node root) {
        //创建用来存放节点的栈
        Stack<Node> nodeStack = new Stack<>();
        Node node = root;
        if (node != null) {
            nodeStack.push(node);
            Node c;
            while (!nodeStack.empty()) {
                c = nodeStack.peek();
                if (c.left != null && node != c.left && node != c.right) {
                    nodeStack.push(c.left);
                } else if (c.right != null && node != c.right) {
                    nodeStack.push(c.right);
                } else {
                    print(nodeStack.pop().value);
                    node = c;
                }
            }
        }
    }

    /**
     * 后续遍历--方法2：
     * 使用两个栈实现后序遍历算法
     *
     * @param head
     */
    public void postOrder2(Node head) {
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();

            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                if (head.left != null) {
                    stack1.push(head.left);
                }

                if (head.right != null) {
                    stack1.push(head.right);
                }

                stack2.push(head);
            }

            while (!stack2.empty()) {
                print(stack2.pop().value);
            }

        }
    }

    private void print(String value) {
        System.out.print(value + " ");
    }
}
