package com.app.dsa.part2.dp_1d;

import java.util.Arrays;

public class MaximizeCut {
    //Function to find the maximum number of cuts.
    public int maximizeCutsDfs(int n, int x, int y, int z, int[] dp) {

        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int opt1 = 1 + maximizeCuts(n - x, x, y, z);

        int opt2 = 1 + maximizeCuts(n - y, x, y, z);
        int opt3 = 1 + maximizeCuts(n - z, x, y, z);


        int ans = Math.max(opt1, opt2);
        ans = Math.max(ans, opt3);
        dp[n] = ans;
        return ans;
    }

    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = maximizeCutsDfs(n, x, y, z, dp);
        if (ans == Integer.MIN_VALUE) {
            return 0;
        }
        return ans;
    }
}
