package com.app.dsa.part2.dp;

import java.util.Arrays;

public class MinMango {
    public static int minimumCostMem(int n, int w, int[] cost, int[][] dp) {
        if (w == 0) {
            return 0;
        }
        if (n == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        int pick = Integer.MAX_VALUE;
        if (cost[n - 1] != -1 && w >= n) {
            pick = minimumCostMem(n, w - n, cost, dp);
            if (pick != Integer.MAX_VALUE) {
                pick += cost[n - 1];
            }
        }
        int skip = minimumCostMem(n - 1, w, cost, dp);
        return dp[n][w] = Math.min(pick, skip);
    }

    public static int minimumCost(int n, int w, int[] cost) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[w + 1];
            Arrays.fill(dp[i], -1);
        }
        int i = minimumCostMem(n, w, cost, dp);
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static void main(String[] args) {

    }


}
