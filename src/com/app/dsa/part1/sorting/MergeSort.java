package com.app.dsa.part1.sorting;

public class MergeSort {


    void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int midLeft = start + (-start + end) / 2;
        int midRight = midLeft + 1;
        int startCopy = start;

        mergeSort(arr, start, midLeft);
        mergeSort(arr, midRight, end);

        int[] res = new int[end - start + 1];

        // 6 7 20
        // 4 5
        int i = 0;
        while (start <= midLeft && midRight <= end) {
            if (arr[start] < arr[midRight]) {
                res[i++] = arr[start++];
            } else {
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

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(new int[]{4, 1, 3, 9, 7}, 0, 4);
    }
}
