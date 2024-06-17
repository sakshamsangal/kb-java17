package com.app.dsa.part1.array;

public class KadaneAlgo {
    // 9
    // -2 1 -3 4 -1 2 1 -5 4
    // sub-array with maximum sum.
    // max sum that ends at ith index
    // e.g. index = 3
    // 4
    // -3 4
    // 1 -3 4
    // -2 1 -3 4
    // 1 2 3 4 5
    // choice 1: we can start a new sub-array
    // choice 2: add to existing sub-array

    public int kadaneAlgo(int[] arr, int size) {
        int[] max = new int[size];
        max[0] = arr[0];
        int maximum = max[0];
        for (int i = 1; i < size; i++) {
            max[i] = Math.max(arr[i], arr[i] + max[i - 1]);
            if (maximum < max[i]) maximum = max[i];
        }
        return maximum;
    }

    public int kadaneAlgo2(int[] arr, int size) {
        int[] max = new int[size*2];
        max[0] = arr[0];
        int maximum = max[0];
        for (int i = 1; i < size; i++) {
            max[i] = Math.max(arr[i], arr[i] + max[i - 1]);
            if (maximum < max[i]) maximum = max[i];
        }
        for (int i = 1; i < size; i++) {
            max[i] = Math.max(arr[i], arr[i] + max[i - 1]);
            if (maximum < max[i]) maximum = max[i];
        }
        return maximum;
    }
    public int kadaneAlgo2(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int[] arr1 = new int[1];


        for (int i = 0; i <= n - 1; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
            arr1[i] = currSum;

        }

        return maxSum;
    }

    public int kadaneAlgo3(int[] input) {
        int globalMaxSum = Integer.MIN_VALUE;
        int localMaxSum = 0;

        for (int j : input) {
            localMaxSum = Math.max(j, j + localMaxSum);
            if (localMaxSum > globalMaxSum) {
                globalMaxSum = localMaxSum;
            }
        }

        return globalMaxSum;
    }

    public static void main(String[] args) {
        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        int[] arr = {-10};
        int i = kadaneAlgo.kadaneAlgo3(arr);
        System.out.println("i = " + i);
    }
}
