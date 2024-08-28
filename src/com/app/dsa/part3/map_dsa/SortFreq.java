package com.app.dsa.part3.map_dsa;

import java.util.*;

public class SortFreq {
    static class Node {
        public int val;
        public int freq;

        public Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public ArrayList<Integer> sortByFreq(int arr[]) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq == o2.freq) {
                return o1.val - o2.val;
            }
            return o2.freq - o1.freq;
        });
        for (int item : arr) {
            Integer freq = freqMap.getOrDefault(item, 0);
            freqMap.put(item, freq + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.add(node);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            for (int i = 0; i < poll.freq; i++) {
                ans.add(poll.val);
            }
        }
        return ans;
    }
}
