package com.app.dsa.part2.graph;

import java.util.ArrayList;

public class Bridge2 {
    public static int dfs(int src, UndGraphGfg gp, int parent, int c, int d) {
        gp.vis[src] = true;
        gp.dis[src] = gp.timer;
        gp.low[src] = gp.timer++;

        for (Integer nei : gp.adj.get(src)) {
            if (!gp.vis[nei]) {
                int bridge = dfs(nei, gp, src, c, d);
                if (bridge == 1) {
                    return 1;
                }
                if (gp.dis[src] >= gp.low[nei]) {
                    // he can go up
                    // he is not ap
                    // let me update my top
                    gp.low[src] = Math.min(gp.low[src], gp.low[nei]);
                } else {
                    // it is bridge
                    if (src == c && nei == d) {
                        return 1;
                    }
                    if (src == d && nei == c) {
                        return 1;
                    }

                }
            } else if (nei != parent) {
                // he is ancestor
                // let me update my top
                // so that I can go up
                gp.low[src] = Math.min(gp.low[src], gp.dis[nei]);
            }
        }
        return 0;
    }


    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        UndGraphGfg gp = new UndGraphGfg(V);
        gp.adj = adj;
        return dfs(0, gp, -1, c, d);

    }
}
