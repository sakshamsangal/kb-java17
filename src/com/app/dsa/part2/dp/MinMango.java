package com.app.dsa.part2.dp;

public class MinMango {
    public static int minimumCostMem(int n, int w, int[] cost) {
        if (w < 1) {
            return 0;
        }
        if (w >= n) {
            int res1 = 0;
            if (cost[n - 1] != -1) {
                res1 = minimumCostMem(n - 1, w - n, cost);
                if (res1 != Integer.MAX_VALUE) {
                    res1 += cost[n - 1];
                }
            }
            int res2 = minimumCostMem(n - 1, w, cost);
            int min = Math.min(res1, res2);
            return min;
        }
        return Integer.MAX_VALUE;
    }

    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int i = minimumCost(n, w, cost);
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {

    }


}
