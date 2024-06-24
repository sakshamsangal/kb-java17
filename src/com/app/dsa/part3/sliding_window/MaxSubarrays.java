package com.app.dsa.part3.sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSubarrays {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[deque.getFirst()]);

        int j = 0;
        for (int i = k; i < n; i++) {
            if (deque.getFirst() < j + 1) {
                deque.removeFirst();
            }
            j++;
            while (!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.add(i);
            ans.add(arr[deque.getFirst()]);
        }
        return ans;
    }
}
