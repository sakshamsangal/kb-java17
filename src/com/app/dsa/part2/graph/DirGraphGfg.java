package com.app.dsa.part2.graph;

import java.util.ArrayList;

public class DirGraphGfg {
    public ArrayList<ArrayList<ArrayList<Integer>>> adj;
    public boolean[] vis;
    public int size;

    public DirGraphGfg(int size) {
        vis = new boolean[size];
        this.size = size;
    }
}
