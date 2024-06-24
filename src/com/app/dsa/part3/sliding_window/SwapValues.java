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

        if (sum < 0) {
            sum = Math.abs(sum);
            int half = sum / 2;
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                set.add(b[i]);
            }
            for (int i = 0; i < n; i++) {
                if (a[i] < half) {
                    if (set.contains(sum - a[i])) {
                        return 1;
                    }
                }
            }
        } else if (sum > 0) {
            sum = Math.abs(sum);
            int half = sum / 2;
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(a[i]);
            }
            for (int i = 0; i < m; i++) {
                if (b[i] < half) {
                    if (set.contains(sum - b[i])) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
