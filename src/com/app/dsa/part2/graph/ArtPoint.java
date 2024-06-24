package com.app.dsa.part2.graph;

import java.util.ArrayList;

public class ArtPoint {
    public void dfs(int src, UndGraphGfg gp, int parent) {
        gp.vis[src] = true;
        gp.dis[src] = gp.timer;
        gp.low[src] = gp.timer++;

        int child = 0;
        for (Integer nei : gp.adj.get(src)) {
            if (!gp.vis[nei]) {
                child++;
                dfs(nei, gp, src);
                if (gp.dis[src] > gp.low[nei]) {
                    // he can go up
                    // he is not ap
                    // let me update my top
                    gp.low[src] = Math.min(gp.low[src], gp.low[nei]);
                } else if (parent != -1) {
                    // he cannot go up
                    // i am ap for him
                    gp.ap[src] = true;
                }
            } else if (nei != parent) {
                // he is ancestor
                // let me update my top
                // so that I can go up
                gp.low[src] = Math.min(gp.low[src], gp.dis[nei]);
            }
        }

        if (parent == -1 && 1 < child) {
            gp.ap[src] = true;
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        UndGraphGfg gp = new UndGraphGfg(V);
        gp.adj = adj;
        dfs(0, gp, -1);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] ap = gp.ap;
        for (int i = 0; i < ap.length; i++) {
            if (ap[i]) {
                ans.add(i);
            }
        }
        if (ans.isEmpty()){
            ans.add(-1);
        }
        return ans;
    }
}
