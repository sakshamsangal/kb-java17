package com.app.dsa.part2.dp_1d;

public class AltMaxLength {

    public int clean(char ch, String pattern, int top, int[] lps) {
        while (top !=-1 && pattern.charAt(top) != ch) {
            if (top == 0){
                // empty the pipe
            }
            top = lps[top - 1];
        }
        return top;
    }


    public int altMax(int[] nums, int start, int prev, String iMustBe) {
        if (start == nums.length - 1) {
            return 1;
        }

        // skip
        int opt1 = altMax(nums, start + 1, prev, iMustBe);

        int opt2 = 0;
        if (iMustBe.equals("gr") && prev < nums[start]) {
            opt2 = 1 + altMax(nums, start + 1, nums[start], "gr");
        } else if (iMustBe.equals("both") && prev != nums[start]) {
            if (prev < nums[start]) {
                opt2 = 1 + altMax(nums, start + 1, nums[start], "sm");
            } else {
                opt2 = 1 + altMax(nums, start + 1, nums[start], "gr");
            }
        }

        return Math.max(opt1, opt2);
    }

    public static void main(String[] args) {
        AltMaxLength altMaxLength = new AltMaxLength();
        int[] arr = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int both = altMaxLength.altMax(arr, 1, arr[0], "both");
        System.out.println("both = " + both + 1);
    }

}
