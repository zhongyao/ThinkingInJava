package com.example.arithmetic.graph;

import java.util.LinkedList;

/**
 * @author：zhongyao
 * @date：2023/3/27
 * @description：
 */
public class Graph {
    /**
     * 节点个数
     */
    Integer nodeSize;
    /**
     * 节点
     */
    char[] node;
    /**
     * 邻接表
     */
    LinkedList[] adj;
    public Graph(char[] node) {
        this.nodeSize = node.length;
        this.node = node;
        this.adj = new LinkedList[nodeSize];
        for (int i = 0 ; i < adj.length ; i++) {
            adj[i] = new LinkedList();
        }
    }

    /**
     * 在节点之间加边，前驱节点指向后继节点
     * @param front 前驱节点所在下标
     * @param end 后继节点所在下标
     */
    public void addEdge(int front, int end) {
        adj[front].add(end);
    }
}
