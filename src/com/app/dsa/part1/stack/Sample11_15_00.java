package com.app.dsa.part1.stack;

import java.util.*;

public class Sample11_15_00 {

    public List<Integer> findMajority(List<Integer> nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maj = nums.size() / 3;
        List<Integer> ans = new ArrayList<>();

        for (Integer key : map.keySet()) {
            if (maj < key) {
                ans.add(key);
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}
