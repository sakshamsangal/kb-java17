package com.app.dsa.part1.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WaterPlant {
    static class Sprinkler {
        int lo;
        int hi;

        public Sprinkler(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        public String toString() {
            return "Sprinkler{" +
                    "lo=" + lo +
                    ", hi=" + hi +
                    '}';
        }
    }

    int min_sprinklers(int[] gallery, int n) {

        List<Sprinkler> sprinklers = new ArrayList<>();
        for (int i = 0; i < gallery.length; i++) {
            if (-1 < gallery[i]) {
                Sprinkler sprinkler = new Sprinkler(i - gallery[i], i + gallery[i]);
                sprinklers.add(sprinkler);
            }
        }
        sprinklers.sort(Comparator.comparingInt(o -> o.lo));

        int target = 0;
        int count = 0;
        for (int i = 0; i < sprinklers.size(); i++) {
            boolean targetAcheived = false;
            while (i < sprinklers.size() && sprinklers.get(i).lo <= target && target <= sprinklers.get(i).hi) {
                targetAcheived = true;
                i++;
            }

            if (targetAcheived) {
                i--;
                count++;
                target = sprinklers.get(i).hi + 1;
                if (target >= gallery.length) {
                    break;
                }
            }
        }

        if (target >= gallery.length) {
            return count;
        }
        return -1;

    }

    public static void main(String[] args) {
        WaterPlant waterPlant = new WaterPlant();
        // int[] arr = {2, 3, 4, -1, 0, 0, 1, 0, 0};
        int[] arr = {2, 3, 4, -1, 0, 0, 0, 0, 0};
        int i = waterPlant.min_sprinklers(arr, arr.length);
        System.out.println("i = " + i);
    }
}
