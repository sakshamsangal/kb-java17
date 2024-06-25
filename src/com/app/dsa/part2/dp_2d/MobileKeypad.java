package com.app.dsa.part2.dp_2d;

import java.util.Arrays;

public class MobileKeypad {
    public long getCountUtil(int n, int x, int y, long[][][] dp) {


        if (x < 0 || x == 4 || (x == 3 && (y == 0 || y == 2)) || y < 0 || 2 < y) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (dp[x][y][n] != -1) {
            return dp[x][y][n];
        }
        // up
        long a = getCountUtil(n - 1, x - 1, y, dp);

        // down
        long b = getCountUtil(n - 1, x + 1, y, dp);

        // left
        long c = getCountUtil(n - 1, x, y - 1, dp);

        // right
        long d = getCountUtil(n - 1, x, y + 1, dp);

        // self
        long e = getCountUtil(n - 1, x, y, dp);

        dp[x][y][n] = a + b + c + d + e;
        return dp[x][y][n];
    }

    public long getCount(int n) {
        long countUtil = 0;
        long[][][] dp = new long[5][][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new long[5][];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = new long[n + 1];
                Arrays.fill(dp[i][j], -1);
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                countUtil += getCountUtil(n, i, j, dp);
            }
        }
        return countUtil;
    }

    public static void main(String[] args) {
        MobileKeypad mobileKeypad = new MobileKeypad();
        long count = mobileKeypad.getCount(6);
        System.out.println("count = " + count);
    }
}
