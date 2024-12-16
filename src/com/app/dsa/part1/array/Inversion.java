package com.app.dsa.part1.array;

public class Inversion {


    static int mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int midLeft = start + (-start + end) / 2;
        int midRight = midLeft + 1;
        int startCopy = start;

        int invCountLeft = mergeSort(arr, start, midLeft);
        int invCountRight = mergeSort(arr, midRight, end);

        int[] res = new int[end - start + 1];

        // 6 7 20
        // 4 5
        int i = 0;
        int invCount = 0;
        while (start <= midLeft && midRight <= end) {
            if (arr[start] <= arr[midRight]) {
                res[i++] = arr[start++];
            } else {
                invCount += midLeft - start + 1;
                res[i++] = arr[midRight++];
            }
        }
        while (start <= midLeft) {
            res[i++] = arr[start++];
        }
        while (midRight <= end) {
            res[i++] = arr[midRight++];
        }

        int k = 0;
        for (int j = startCopy; j <= end; j++) {
            arr[j] = res[k++];
        }

        return invCountLeft + invCountRight + invCount;
    }

    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

}
