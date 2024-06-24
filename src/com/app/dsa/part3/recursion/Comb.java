package com.app.dsa.part3.recursion;

import java.util.ArrayList;
import java.util.List;

public class Comb {
    public void combination(int n, int r, int lo, List<Integer> list) {
        if (r == 0) {
            System.out.println("list = " + list);
        }
        for (int i = lo; i <= n; i++) {
            list.add(i);
            combination(n, r - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Comb comb = new Comb();
        List<Integer> list = new ArrayList<>();

        comb.combination(4, 3, 1, list);
    }
}
