package com.app.dsa.part2.dp_1d;

import java.util.List;
import java.util.Stack;

public class Sample12_42_34 {
    public List<Integer> recFind3Numbers(int[] arr, int start, Stack<Integer> stack) {
        if (stack.size() != 3) {
            stack.push(arr[start]);
            recFind3Numbers(arr, start + 1, stack);
            recFind3Numbers(arr, start + 1, stack);
            if (true) {
                stack.pop();
            }
        }
        return null;
    }

    public List<Integer> find3Numbers(int[] arr) {
        // code here
        return null;
    }
}
