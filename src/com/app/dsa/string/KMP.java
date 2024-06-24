package com.app.dsa.string;

import java.util.ArrayList;

public class KMP {
    ArrayList<Integer> search(String pat, String text) {
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lps = getLps(pat);
        for (int i = 0; i < text.length(); i++) {
            while (pat.charAt(j) != text.charAt(i)) {
                if (j == 0) {
                    j = -1;
                    break;
                }
                j = lps[j - 1];
            }
            j++;
            if (pat.length() == j) {
                ans.add(i - j + 1);
                j = lps[j - 1];
            }
        }
        return ans;
    }


    private static int[] getLps(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0;
        lps[0] = 0;
        for (int i = 1; i < pat.length(); i++) {
            while (pat.charAt(len) != pat.charAt(i)) {
                if (len == 0) {
                    len--;
                    break;
                } else {
                    len = lps[len - 1];
                }
            }
            len++;
            lps[i] = len;
        }
        return lps;
    }


}