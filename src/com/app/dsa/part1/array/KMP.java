package com.app.dsa.part1.array;

import java.util.ArrayList;

public class KMP {
    //cec
    // aacecaaaa
    // --aa
    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lps = getLps1(pat);
        int j = 0;
        for (int i = 0; i < txt.length(); i++) {
            while (txt.charAt(i) != pat.charAt(j)) {
                if (j == 0) {
                    j = -1;
                    break;
                }
                j = lps[j - 1];
            }
            j++;
            if (j == pat.length()) {
                ans.add(i - j + 1);
                j = lps[j - 1];
            }
        }

        return ans;
    }

    private int[] getLps1(String txt) {
        int[] lps = new int[txt.length()];
        for (int i = 1; i < lps.length; i++) {
            int j = lps[i - 1];
            while (txt.charAt(i) != txt.charAt(j)) {
                if (j == 0) {
                    j = -1;
                    break;
                }
                j = lps[j - 1];
            }
            lps[i] = j + 1;
        }
        return lps;
    }
}
