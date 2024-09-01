package com.app.dsa.part2.dp_1d;

public class Sample12_55_15 {

    static int recKnapSack(int start, int W, int wt[], int val[]) {
        if (start == wt.length) {
            return 0;
        }
        int picked = 0;
        if (wt[start] <= W) {
            picked = val[start] + recKnapSack(start + 1, W - wt[start], wt, val);
        }
        int skip = recKnapSack(start + 1, W, wt, val);
        int max = Math.max(picked, skip);
        return max;
    }

    static int knapSack(int W, int wt[], int val[]) {

        return W;
    }
}
