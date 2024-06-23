package com.app.dsa.part1.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class WaterPlant {
    static class Tap {
        int lo;
        int hi;

        public Tap(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }
    }

    int min_sprinklers(int[] gallery, int n) {

        PriorityQueue<Tap> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.lo));

        for (int i = 0; i < gallery.length; i++) {
            if (-1 < gallery[i]) {
                Tap tap = new Tap(i - gallery[i], i + gallery[i]);
                pq.add(tap);
            }
        }

        int target = 0;
        int count = 0;
        while (target < n) {
            int rMax = -1;
            while (!pq.isEmpty()) {
                Tap tap = pq.peek();
                if (target < tap.lo) {
                    break;
                } else {
                    pq.poll();
                    rMax = Math.max(rMax,tap.hi);
                }
            }
            if (rMax < target) {
                return -1;
            }
            target = rMax + 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        WaterPlant waterPlant = new WaterPlant();
        int[] arr = {2, 3, 4, -1, 0, 0, 0, 0, 0};
        waterPlant.min_sprinklers(arr, 9);
    }
}
