package com.app.dsa.part2.graph;

import java.util.ArrayList;

public class Dfs {
    public void dfs(int src, UndGraphGfg undGraph) {
        undGraph.vis[src] = true;
        undGraph.nodes.add(src);
        for (Integer nei : undGraph.adj.get(src)) {
            if (!undGraph.vis[nei]) {
                dfs(nei, undGraph);
            }
        }
    }

    public ArrayList<Integer> dfsWrapper(UndGraphGfg undGraph) {
        for (int i = 0; i < undGraph.size; i++) {
            if (!undGraph.vis[i]) {
                dfs(0, undGraph);
            }
        }
        return undGraph.nodes;
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        UndGraphGfg undGraph = new UndGraphGfg(V);
        undGraph.adj = adj;
        return dfsWrapper(undGraph);
    }
}
