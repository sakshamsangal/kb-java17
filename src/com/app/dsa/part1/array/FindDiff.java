package com.app.dsa.part1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindDiff {
    public int findMaxDiff(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);

        for (int i = 1; i < left.length; i++) {
            // keep on popping
            while (!st.isEmpty() && arr[i] <= st.peek()) {
                st.pop();
            }

            if (!st.empty()) {
                left[i] = st.peek();
            }

            st.push(arr[i]);
        }
        st.clear();
        st.push(arr[arr.length - 1]);

        for (int i = right.length - 2; i > -1; i--) {
            // keep on popping
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (!st.empty()) {
                right[i] = st.peek();
            }
            st.push(arr[i]);
        }

        int max = Math.abs(left[0] - right[0]);
        for (int i = 1; i < left.length; i++) {
            max = Math.max(max, Math.abs(left[i] - right[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        FindDiff findDiff = new FindDiff();
        int[] arr = {2, 4, 8, 7, 7, 9, 3};
        findDiff.findMaxDiff(arr);
    }
}
