package com.example.graph;

import java.util.List;

/**
 * @author：zhongyao
 * @date：2023/3/29
 * @description：
 */
public class GraphTest {

    public static void main(String[] strings) {
        //初始化一个图
        Graph graph = new Graph(new char[]{'A', 'B', 'C', 'D'});
        graph.addEdge(0, 1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        //进行拓扑排序
        List<Character> resultToPo = ToPoLogicalSortUtil.toPoLogicalSort(graph);
        System.out.println("resultToPo:" + resultToPo);
    }
}
