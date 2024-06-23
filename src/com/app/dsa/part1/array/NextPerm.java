package com.app.dsa.part1.array;

public class NextPerm {
    public void swapArrItem(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        // dip
        int dip = -1;
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] < nums[i + 1]) {
                dip = i;
                break;
            }
        }
        if (dip != -1) {
            for (int i = nums.length - 1; i > -1; i--) {
                if (nums[dip] < nums[i]) {
                    swapArrItem(nums, dip, i);
                    break;
                }
            }
        }

        int n = nums.length - dip - 1;

        for (int i = dip + 1; i < n / 2; i++) {
            swapArrItem(nums, i, n - i - 1);
        }

    }
}
