package com.app;

import java.text.MessageFormat;

public class Solution {
    public int solve(int ind, int prevSum, int n, String str, int dp[][]) {
        System.out.println(MessageFormat.format("f({0}, {1})", ind, prevSum));
        if (ind == n) {
            return 1;
        }

        int count = 0, sum = 0;
        for (int i = ind; i < n; i++) {
            sum += str.charAt(i) - '0';
            if (prevSum <= sum) {
                count += solve(i + 1, sum, n, str, dp);
            }
        }

        return count;
    }

    public int TotalCount(String str) {
        int n = str.length();
        int dp[][] = new int[n][10];

//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < 1000; j++)
//                dp[i][j] = -1;

        return solve(0, 0, n, str, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.TotalCount("531");
    }
}