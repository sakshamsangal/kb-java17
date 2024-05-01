package com.app.dsa.part1;

import java.util.*;

public class StringDsa {


    public boolean wordPattern(String pattern, String s) {

        String[] arr = s.split("\\s");
        if (pattern.length() != arr.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s1 = map.get(c);
            if (s1 == null) {
                if (set.contains(arr[i])) {
                    return false;
                }
                map.put(c, arr[i]);
                set.add(arr[i]);
            } else if (!Objects.equals(s1, arr[i])) {
                return false;
            }
        }

        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (int i = start; i < s.length(); i++) {
            start = isPresent(start, s.charAt(i), t);
            if (start == -1) {
                return false;
            }
        }
        return true;
    }

    private int isPresent(int start, char c, String t) {
        for (int i = start; i < t.length(); i++) {
            if (c == t.charAt(i)) return i + 1;
        }
        return -1;
    }

    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();

        int jump = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += jump) {
                ans.append(s.charAt(j));
                if (0 < i && i < numRows - 1) {
                    int jump2 = j + jump - 2 * i;
                    if (jump2 < s.length()) {
                        ans.append(s.charAt(jump2));
                    }
                }
            }
        }


        return ans.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings...
        if (s.length() != t.length())
            return false;
        // Create two maps for s & t strings...
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        // Traverse all elements through the loop...
        for (int idx = 0; idx < s.length(); idx++) {
            // Compare the maps, if not equal, return false...
            System.out.println("map1 = " + map1[s.charAt(idx)]);
            System.out.println("map2 = " + map2[t.charAt(idx)]);
            System.out.println();
            if (map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;

            // Insert each character if string s and t into separate map...
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;

        }
        return true;    // Otherwise return true...
    }

//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Character> map = new HashMap<>();
//        HashSet<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                if (map.get(s.charAt(i)) != t.charAt(i)) {
//                    return false;
//                }
//            } else {
//                if (set.contains(t.charAt(i))){
//                    return false;
//                }
//                set.add(t.charAt(i));
//                map.put(s.charAt(i), t.charAt(i));
//            }
//
//        }
//        return true;
//    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // letter occurrence
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 97]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int j = ransomNote.charAt(i) - 97;
            if (arr[j] == 0) {
                return false;
            }
            arr[j]--;
        }
        return true;
    }


    public String reverseWords(String s) {
        int start = s.length() - 1;
        int end = start;
        StringBuilder stringBuilder = new StringBuilder();
        while (-1 < start) {
            // success
            while (s.charAt(end) == ' ') {
                start--;
                end--;
            }

            while (s.charAt(start) != ' ') {
                start--;
            }
            for (int i = start + 1; i <= end; i++) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return s;
    }

    public String reverseWords2(String s) {
        String[] arr = s.trim().split("\\s+");
        String[] ans = new String[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            ans[j++] = arr[i];
        }
        return String.join(" ", ans);
    }


    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, bank);
        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        for (String s : bank) {
            visited.put(s, false);
        }
        queue.add(startGene);
        visited.put(startGene, true);
        int level = 0;
        while (!queue.isEmpty()) {
            String polled = queue.poll();
            if (Objects.equals(polled, endGene)) {
                return level;
            }
            List<String> genes = getValidMutations(polled, set);
            for (String gene : genes) {
                if (!visited.get(gene)) {
                    visited.put(gene, true);
                    queue.offer(gene);
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> getValidMutations(String startGene, Set<String> set) {
        List<String> list = new ArrayList<>();
        char[] charArray = startGene.toCharArray();
        char[] arr = new char[]{'A', 'C', 'G', 'T'};
        for (int i = 0; i < charArray.length; i++) {
            char temp = charArray[i];
            for (char c : arr) {
                charArray[i] = c;
                String gene = new String(charArray);
                if (set.contains(gene)) {
                    list.add(gene);
                }
            }
            charArray[i] = temp;
        }
        return list;
    }

    public int compress(char[] arr) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int letterCount = 1;

            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                letterCount++;
                i++;
            }
            ans.append(arr[i]);
            if (1 < letterCount) {
                ans.append(letterCount);
            }
        }
        for (int k = 0; k < ans.length(); k++) {
            arr[k] = ans.charAt(k);
        }
        return ans.length();
    }


    public String mergeAlternately(String word1, String word2) {

        StringBuilder altStr = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            altStr.append(word1.charAt(i));
            altStr.append(word2.charAt(j));
            i++;
            j++;
        }
        while (i < word1.length()) {
            altStr.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            altStr.append(word2.charAt(j));
            j++;
        }
        return altStr.toString();
    }

    private boolean[] vowelLetterMap() {
        boolean[] letter = new boolean[128];
        char[] vowels = "aeiouAEIOU".toCharArray();
        for (char c : vowels) {
            letter[c] = true;
        }
        return letter;
    }

    public String reverseVowels(String s) {
        int end = s.length() - 1;
        char[] chs = s.toCharArray();
        boolean[] letter = vowelLetterMap();
        for (int i = 0; i < chs.length; i++) {
            if (letter[chs[i]]) {
                for (int j = end; j > i; j--) {
                    if (letter[chs[j]]) {
                        char temp = chs[i];
                        chs[i] = chs[j];
                        chs[j] = temp;
                        end = j - 1;
                        break;
                    }
                }
            }
        }

        return String.valueOf(chs);
    }

    ArrayList<Integer> search(String pat, String txt) {
        int winLen = 2;
        for (int i = 0; i < txt.length() - 1; i++) {
            System.out.println("txt = " + txt.substring(i, winLen));
            winLen++;
        }

        return null;
    }

    public static void main(String[] args) {
        StringDsa stringDsa = new StringDsa();
        String st = "leetcode";
        stringDsa.search("123", "abc");

    }
}
