package com.example.arithmetic.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：zhongyao
 * @date：2023/3/27
 * @description：
 */
public class ToPoLogicalSortUtil {
    /**
     * @param graph 有向无环图
     * @return 拓扑排序结果
     */
    public static List<Character> toPoLogicalSort(Graph graph) {
        //用一个数组标志所有节点入度
        int[] inDegree = new int[graph.nodeSize];
        for (LinkedList list : graph.adj) {
            for (Object index : list) {
                ++inDegree[(int) index];
            }
        }
        //用一个数组标志所有节点是否已经被访问
        boolean[] visited = new boolean[graph.nodeSize];
        //开始进行遍历
        Deque<Integer> nodes = new LinkedList<>();
        //将入度为0节点入队
        for (int i = 0; i < graph.nodeSize; i++) {
            if (inDegree[i] == 0) {
                nodes.offer(i);
            }
        }
        List<Character> result = new ArrayList<>();
        //将入度为0节点一次出队处理
        while (!nodes.isEmpty()) {
            int node = nodes.poll();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            result.add(graph.node[node]);
            //将当前node的邻接节点入度-1；
            for (Object list : graph.adj[node]) {
                --inDegree[(int) list];
                if (inDegree[(int) list] == 0) {
                    //前驱节点全部访问完毕，入度为0
                    nodes.offer((int) list);
                }
            }
        }
        return result;
    }
}
