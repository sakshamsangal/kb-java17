package com.app.dsa.part1.array;

public class ProductExceptSelf {

    public static long[] productExceptSelf(int nums[]) {

        long[] prefixProd = new long[nums.length];
        prefixProd[0] = 1;
        long sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            prefixProd[i] = prefixProd[i - 1] * nums[i - 1];
        }

        long[] ans = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefixProd[i] * (sum - prefixProd[i]);
        }

        return ans;
    }
}
