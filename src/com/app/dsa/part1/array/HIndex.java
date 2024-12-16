package com.app.dsa.part1.array;

import java.util.Arrays;

public class HIndex {
    // Function to find hIndex
    // 0 1 3 3 5
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int pageCount = 0;
        int hInd = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            pageCount++;
            if (pageCount <= citations[i]) {
                hInd = pageCount;
            } else {
                break;
            }
        }

        return hInd;
    }
}
