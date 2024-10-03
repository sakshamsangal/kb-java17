package com.app.dsa.part1.stack;

import com.app.dsa.model.gfg.Node;

import java.util.*;

public class Sample1_07_16 {

    record Info(int count, int minLen, int start) {
    }


    static Map<Character, Integer> getFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }


    public static String smallestWindow(String s, String p) {

        if (s.length() < p.length()) {
            return "-1";
        }

        int start = 0;
        int count = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = getFrequency(p);

        for (int i = 0; i < s.length(); i++) {
            count = addItem(s.charAt(i), count, map);

            while (count == p.length()) {
                // store ans
                int len = i - start + 1;
                if (len < minLen) {
                    minLen = len;
                    j = start;
                }

                count = removeItem(s.charAt(start), count, map);
                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "-1";
        }
        return s.substring(j, j + minLen);
    }

    private static int addItem(char s_ch, int count, Map<Character, Integer> map) {
        Integer val = map.getOrDefault(s_ch, 0);
        map.put(s_ch, val - 1);

        if (-1 < val) {
            count++;
        }
        return count;
    }

    private static int removeItem(char s_ch, int count, Map<Character, Integer> map) {
        Integer val1 = map.get(s_ch);
        map.put(s_ch, val1 + 1);
        if (0 < val1) {
            count++;
        }
        return count;
    }


}