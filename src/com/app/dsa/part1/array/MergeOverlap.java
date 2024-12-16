package com.app.dsa.part1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class MergeOverlap {

    public List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(new ToIntFunction<int[]>() {
            @Override
            public int applyAsInt(int[] o) {
                return o[0];
            }
        }));

        List<int[]> interval = new ArrayList<>();
        interval.add(arr[0]);
        int[] prev = interval.get(0);
        for (int i = 1; i < arr.length; i++) {
            int[] curr = arr[i];
            if (curr[0] < prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                interval.add(curr);
                prev = curr;
            }
        }

        return interval;
    }
}