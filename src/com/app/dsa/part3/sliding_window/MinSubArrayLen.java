package com.app.dsa.part3.sliding_window;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int i = minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println("i = " + i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int saSum = nums[0];
        int j = 0;
        int i = 1;
        int minLen = nums.length + 1;
        while (i < nums.length) {
            if (saSum < target) {
                saSum += nums[i];
                i++;
            } else {
                minLen = Math.min(minLen, i - j);
                saSum -= nums[j];
                j++;
            }
        }
        while (saSum >= target) {
            minLen = Math.min(minLen, i - j);
            saSum -= nums[j];
            j++;
        }
        return nums.length + 1 == minLen ? 0 : minLen;
    }

}
