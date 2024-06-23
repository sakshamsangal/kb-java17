package com.app.dsa.part2.dp;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/maximize-dot-product2649/1
public class MaxDotProduct {
    public int mdpUtil(int n, int m, int[] a, int[] b, int[][] dp) {
        if (n < 0 || m < 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        int opt1 = a[n] * b[m] + mdpUtil(n - 1, m - 1, a, b, dp);
        int opt2 = 0;
        if (m < n) {
            opt2 = mdpUtil(n - 1, m, a, b, dp);
        }

        dp[n][m] = Math.max(opt1, opt2);
        return dp[n][m];
    }

    public int mdpTab(int n, int m, int[] a, int[] b) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int opt1 = a[i - 1] * b[j - 1] + dp[i - 1][j - 1];
                int opt2 = (j < i) ? dp[i - 1][j] : 0;
                dp[i][j] = Math.max(opt1, opt2);
            }
        }

        return dp[n][m];
    }

    public int maxDotProduct(int n, int m, int a[], int b[]) {
        int[][] dp = new int[n][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[m];
            Arrays.fill(dp[i], -1);
        }

        return mdpUtil(n - 1, m - 1, a, b, dp);
    }

    public static void main(String[] args) {
        MaxDotProduct maxDotProduct = new MaxDotProduct();
        int n = 5;
        int a[] = {2, 3, 1, 7, 8};
        int m = 3;
        int b[] = {3, 6, 7};
//        int i = maxDotProduct.maxDotProduct(n, m, a, b);
        int i = maxDotProduct.mdpTab(n, m, a, b);
        System.out.println("i = " + i);
    }
}
