package com.app.dsa.part2.graph;

import java.util.ArrayList;
import java.util.List;

public class ArtPoint {
    public static void main(String[] args) {
//        UndGraph undGraph = new UndGraph(5);
//        addEdge(0, 1);
//        addEdge(1, 4);
//        addEdge(2, 4);
//        addEdge(3, 4);
//        addEdge(2, 3);
//
//        ArtPoint artPoint = new ArtPoint();
//
//        int i = artPoint.getAp(0, undGraph, -1);
    }


    int timer = 0;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] dis = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];

        dfs(0, adj, -1, dis, low, visited, ap);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                list.add(i);
            }
        }
        if (list.isEmpty()){
            list.add(-1);
        }
        return list;

    }

    private void dfs(int src, ArrayList<ArrayList<Integer>> adj, int par, int[] dis, int[] low, boolean[] visited, boolean[] ap) {
        dis[src] = timer++;
        low[src] = dis[src];
        visited[src] = true;
        List<Integer> neiList = adj.get(src);
        int child = 0;
        for (Integer nei : neiList) {
            if (!visited[nei]) {
                child++;
                dfs(nei, adj, src, dis, low, visited, ap);
                if (low[nei] < dis[src]) {
                    // he can go up
                    // he is not ap
                    // let me update my top
                    low[src] = Math.min(low[src], low[nei]);
                } else if (par != -1) {
                    // he cannot go up
                    // i am ap for him
                    ap[src] = true;
                }
            } else if (nei != par) {
                // he is ancestor
                // let me update my top
                // so that I can go up
                low[src] = Math.min(low[src], dis[nei]);
            }
        }
        if (par == -1 & child > 1) {
            ap[src] = true;
        }
    }
}
