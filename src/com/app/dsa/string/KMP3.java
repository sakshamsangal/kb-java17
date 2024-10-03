package com.app.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP3 {
    ArrayList<Integer> search(String pat, String text) {
        ArrayList<Integer> ans = new ArrayList<>();
        int j = 0;
        int[] lps = getLps(pat);
        for (int i = 0; i < text.length(); i++) {
            j = checkIfCharMatches(text, pat, lps, i, j) + 1;
            if (pat.length() == j) {
                ans.add(i - j + 2);
                j = lps[j - 1];
            }
        }
        return ans;
    }


    private static int[] getLps(String pat) {
        int[] lps = new int[pat.length()];
        for (int i = 1; i < pat.length(); i++) {
            lps[i] = checkIfCharMatches(pat, pat, lps, i, lps[i - 1]) + 1;
        }
        return lps;
    }

    private static int checkIfCharMatches(String s1, String s2, int[] lps, int i, int j) {
        while (s1.charAt(i) != s2.charAt(j)) {
            if (j == 0) {
                return -1;
            }
            j = lps[j - 1];
        }
        return j;
    }

    public static void main(String[] args) {
        KMP3 kMP3 = new KMP3();
        int[] lps = getLps("01230123");
        System.out.println("lps = " + Arrays.toString(lps));
    }


}