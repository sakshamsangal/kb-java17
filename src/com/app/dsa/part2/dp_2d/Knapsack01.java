package com.app.dsa.part2.dp_2d;

import java.util.Arrays;

public class Knapsack01 {
    int knapSackUt(int W, int wt[], int val[], int[][] dp, int lo) {
        int maxValue = 0;
        if (dp[lo][W] != -1) {
            return dp[lo][W];
        }
        for (int i = lo; i < wt.length; i++) {
            if (wt[i] <= W) {
                int value = val[i] + knapSackUt(W - wt[i], wt, val, dp, i + 1);
                maxValue = Math.max(maxValue, value);
            }
        }
        return dp[lo][W] = maxValue;
    }

    int knapSackTab(int W, int wt[], int val[]) {
        int n = wt.length;
        int[] dpPrev = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w > -1; w--) {
                if (wt[i] <= w) {
                    dpPrev[w] = Math.max(val[i] + dpPrev[w - wt[i]], dpPrev[w]);
                }
            }
        }
        return dpPrev[W];
    }

    public int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[W + 1];
            Arrays.fill(dp[i], -1);
        }
        return knapSackUt(W, wt, val, dp, 0);
    }

    public static void main(String[] args) {
        Knapsack01 dp2Dim = new Knapsack01();
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};

//        int[] profit = {1, 2, 3};
//        int[] weight = {4, 5, 1};

//        int i = dp2Dim.knapSack(50, weight, profit, weight.length);
//        int i = dp2Dim.knapSackTab(4, weight, profit);
        int i = dp2Dim.knapSackTab(50, weight, profit);
        System.out.println("i = " + i);

    }


}