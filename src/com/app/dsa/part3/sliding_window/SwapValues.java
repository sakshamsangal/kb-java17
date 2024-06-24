package com.app.dsa.part3.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class SwapValues {

    // FIXME: 6/24/2024 not done
    long findSwapValues(long a[], int n, long b[], int m) {
        int sum = 0;
        for (long l : a) {
            sum += l;
        }
        for (long l : b) {
            sum -= l;
        }
        if (sum == 0) {
            return 1;
        }
        if (sum % 2 == 1) {
            return -1;
        }

        sum = Math.abs(sum);
        int half = sum / 2;
        Set<Long> set = new HashSet<>();
        if (sum < 0) {
            for (long l : b) {
                set.add(l);
            }
            for (long l : a) {
                if (l < half && set.contains(sum - l)) {
                    return 1;

                }
            }
        } else {
            for (long l : a) {
                set.add(l);
            }
            for (long l : b) {
                if (l < half && set.contains(sum - l)) {
                    return 1;
                }
            }
        }
        return -1;
    }
}
