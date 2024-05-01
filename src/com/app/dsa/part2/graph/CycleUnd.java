package com.app.dsa.part2.graph;

import java.util.ArrayList;

public class CycleUnd {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;

        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (DFSRec(adj, u, visited, s)) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (DFSRec(adj, i, visited, -1))
                    return true;
        }
        return false;
    }


    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, int par) {
        vis[src] = true;
        for (int child : adj.get(src)) {
            if (!vis[child]) {
                if (dfs(adj, child, vis, src)) {
                    return true;
                }
            } else {
                if (child != par) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs2(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, int par) {
        vis[src] = true;

        // visit child
        for (int child : adj.get(src)) {
            if (child == par){
                continue;
            }
            if (vis[child]) {
                return true;
            }
            if (dfs2(adj, child, vis, src)) {
                return true;
            }
        }
        return false;
    }



    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(adj, i, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isCycleUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, boolean[] recSt) {
        vis[src]=true;
        recSt[src]=true;
        for (Integer nei : adj.get(src)) {
            if (!vis[nei]) {
                if (isCycleUtil(adj, nei, vis, recSt)) {
                    return true;
                }
            } else if (recSt[nei]){
                return true;
            }
        }
        recSt[src]=false;
        return false;
    }


    // Function to detect cycle in an directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        boolean[] recSt = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycleUtil(adj, i, vis, recSt)) {
                    return true;
                }
            }
        }
        return false;
    }



}
