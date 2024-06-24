package com.app.dsa.part3.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinct {

    Map<Integer, Integer> getFrequencyFromArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer freq = map.getOrDefault(item, 0);
            map.put(item, freq + 1);
        }
        return map;
    }

    ArrayList<Integer> countDistinct(int nums[], int n, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Integer freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq + 1);
        }
        list.add(map.size());
        int j = 0;
        for (int i = k; i < n; i++) {
            Integer val = map.get(nums[j]);
            if (val == 1) {
                map.remove(nums[j]);
            } else {
                map.put(nums[j], val - 1);
            }
            j++;

            Integer val2 = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val2 + 1);

            list.add(map.size());
        }
        return list;
    }

    public static void main(String[] args) {
        CountDistinct countDistinct = new CountDistinct();
        int N = 7;
        int K = 4;
        int A[] = {1, 2, 1, 3, 4, 2, 3};
        ArrayList<Integer> integers = countDistinct.countDistinct(A, N, K);
        System.out.println("integers = " + integers);
    }
}
