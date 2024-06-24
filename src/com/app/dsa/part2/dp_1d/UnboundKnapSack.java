package com.app.dsa.part2.dp_1d;

import java.util.Arrays;

public class UnboundKnapSack {

    static int knapSackTab(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];

        for (int w = 1; w <= W; w++) {
            // Iterate over all items
            for (int i = 0; i < wt.length; i++) {
                // If the current item's weight is less than or equal to the current weight capacity
                if (w >= wt[i]) {
                    // Update dp[w] to be the maximum of its current value or the value by including the current item
                    int value = val[i] + dp[w - wt[i]];
                    dp[w] = Math.max(dp[w], value);
                }
            }
        }

        return dp[W];
    }

    static int knapSackMem(int W, int[] val, int[] wt, int[] dp) {
        if (W == 0) {
            return 0;
        }
        if (dp[W] != -1) {
            return dp[W];
        }
        int maxValue = 0;
        for (int i = 0; i < wt.length; i++) {
            if (W >= wt[i]) {
                int value = val[i] + knapSackMem(W - wt[i], val, wt, dp);
                maxValue = Math.max(maxValue, value);
            }
        }
        // code here
        return dp[W] = maxValue;
    }

    static int knapSack(int N, int W, int val[], int wt[]) {
        // code here
        int[] dp = new int[W + 1];
        Arrays.fill(dp, -1);
        int i = knapSackMem(W, val, wt, dp);
        return i;
    }

    public static void main(String[] args) {
        int N = 2;
        int W = 3;
        int[] val = {1, 1};
        int[] wt = {2, 1};
        knapSackTab(W, val, wt);
    }
}
