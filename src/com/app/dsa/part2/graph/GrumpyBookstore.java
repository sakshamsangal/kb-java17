package com.app.dsa.part2.graph;

public class GrumpyBookstore {

    public int maxSatisfied(int[] cus, int[] ao, int min) {
        int hc = 0;
        int ac = 0;
        for (int i = 0; i < min; i++) {
            if (ao[i] == 1) {
                ac += cus[i];
            } else {
                hc += cus[i];
            }
        }
        int lo = 0;
        int acMax = ac;
        for (int i = min; i < cus.length; i++) {
            if (ao[lo] == 1) {
                ac -= cus[lo];
            }
            if (ao[i] == 1) {
                ac += cus[i];
            } else {
                hc += cus[i];
            }
            acMax = Math.max(acMax, ac);
            lo++;
        }

        return hc + acMax;
    }

    public static void main(String[] args) {

        GrumpyBookstore grumpyBookstore = new GrumpyBookstore();
        int[] cust = {1, 1, 1, 2, 1, 1, 7, 5};
        int[] irritated = {0, 1, 0, 1, 0, 1, 0, 1};
        int i = grumpyBookstore.maxSatisfied(cust, irritated, 3);
        System.out.println("i = " + i);
    }
}
