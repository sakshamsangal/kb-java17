package com.app.dsa.part2.graph;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    int timer = 0;

    void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    private List<List<Integer>> getAdjList(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            addEdge(adj, edge.get(0), edge.get(1));
        }
        return adj;
    }

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = getAdjList(V, edges);

        int[] dis = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        List<List<Integer>> list = new ArrayList<>();
        dfs(0, adj, -1, dis, low, visited, list);
        return list;
    }

    private void dfs(int src, List<List<Integer>> adj, int par, int[] dis, int[] low, boolean[] visited, List<List<Integer>> ans) {
        dis[src] = timer++;
        low[src] = dis[src];
        visited[src] = true;
        List<Integer> neiList = adj.get(src);
        for (Integer nei : neiList) {
            if (!visited[nei]) {
                dfs(nei, adj, src, dis, low, visited, ans);
                if (low[nei] <= dis[src]) {
                    // he can go up & to me
                    // let me update my top
                    low[src] = Math.min(low[src], low[nei]);
                } else {
                    // this road is bridge
                    List<Integer> list = new ArrayList<>();
                    list.add(src);
                    list.add(nei);
                    ans.add(list);
                }
            } else if (nei != par) {
                // he is ancestor
                // let me update my top
                // so that I can go up
                low[src] = Math.min(low[src], dis[nei]);
            }
        }
    }
}
