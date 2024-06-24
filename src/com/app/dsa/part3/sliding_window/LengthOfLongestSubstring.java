package com.app.dsa.part3.sliding_window;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] freq = new int[128];

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (freq[c] == 1) {
                freq[s.charAt(j)]--;
                j++;
            }

            freq[c]++;
            maxLen = Math.max(maxLen, i - j);
        }
        return maxLen;
    }
}
