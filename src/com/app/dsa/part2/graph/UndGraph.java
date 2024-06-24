package com.app.dsa.part2.graph;

import java.util.ArrayList;
import java.util.List;


public class UndGraph {
    public List<List<Integer>> adj;
    public int size;
    public boolean[] vis;
    public List<Integer> nodes;
    public UndGraph(int size) {
        vis = new boolean[size];
        nodes = new ArrayList<>(size);

        this.size = size;
        this.adj = new ArrayList<>(size);
        for (int i = 0; i < this.size; i++) {
            adj.add(new ArrayList<>());
        }
    }


    void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
