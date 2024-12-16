package com.app.dsa.part1.array;

public class MinChar {
    public static int minChar(String s) {

        // fxtlsgypsfa
        // cbaabc - afspygsltx
        // afxtlsgypsfa
        // afsxtlsgypsfa 2
        // 3 afspxtlsgypsfa
        // 4 afspyxtlsgypsfa
        // 5 afspyg xtls gypsfa
        // 6 afspygs xtl sgypsfa
        // 7 afspygsl xt lsgypsfa
        // 8 afspygslt x tlsgypsfa
        int start = 0;
        int end = s.length() - 1;
        int count = 0;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
            } else {
                count++;
            }
            end--;
        }


        return count;
    }
}