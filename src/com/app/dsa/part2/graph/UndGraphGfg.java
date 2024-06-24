package com.app.dsa.part2.graph;

import java.util.ArrayList;
import java.util.List;


public class UndGraphGfg {
    public ArrayList<ArrayList<Integer>> adj;
    public int size;
    public int timer;
    public boolean[] vis;
    public boolean[] ap;
    public int[] dis;
    public int[] low;
    public ArrayList<Integer> nodes;

    public UndGraphGfg(int size) {
        vis = new boolean[size];
        ap = new boolean[size];
        dis = new int[size];
        low = new int[size];
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
