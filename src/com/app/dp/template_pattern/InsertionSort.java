package com.app.dp.template_pattern;

public class InsertionSort extends Algorithm {

    public InsertionSort(int[] nums) {
        super(nums);
    }

    @Override
    protected void initialize() {
        System.out.println("Initializing the insertion sort algorithm...");
    }

    @Override
    protected void sorting() {
        for (int i = 1; i < nums.length; i++) {
            int item = nums[i];
            int loc = getLoc(nums, i - 1, item);
            nums[loc] = item;
        }
    }

    private int getLoc(int[] nums, int end, int item) {
        while (-1 < end) {
            if (nums[end] < item) {
                return end + 1;
            }
            nums[end + 1] = nums[end];
            end--;
        }
        return 0;
    }

    @Override
    protected void showResult() {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
