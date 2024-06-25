package com.app.dsa.string;

import java.util.ArrayList;

public class Kmp2 {

    ArrayList<Integer> search(String pat, String text) {

        ArrayList<Integer> ans = new ArrayList<>();

        int j = 0;
        int[] lps = getLps(pat);
        for (int i = 0; i < text.length(); i++) {
            while (text.charAt(i) != pat.charAt(j)) {
                if (j == 0) {
                    j = -1;
                    break;
                }
                j = lps[j - 1];
            }
            j++;
            if (j == pat.length()) {
                ans.add(i - j + 2);
                j = lps[j - 1];
            }
        }
        return ans;
    }

    private static int[] getLps(String pat) {
        int[] lps = new int[pat.length()];
        lps[0] = 0;
        int len = 0;

        for (int i = 1; i < pat.length(); i++) {
            while (pat.charAt(i) != pat.charAt(len)) {
                if (len == 0) {
                    len = -1;
                    break;
                }
                len = lps[len - 1];
            }
            len++;
            lps[i] = len;
        }

        return lps;
    }

    public static void main(String[] args) {

    }
}
