package com.app.dsa.part3.recursion;

import java.util.Arrays;
import java.util.List;

public class FindPermutation {
    public static void swapArrItem(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<String> permRec(char[] chars, int lo) {
        if (lo == chars.length - 1) {
            System.out.println("per = " + Arrays.toString(chars));
            return null;
        }
        for (int i = lo; i < chars.length; i++) {
            swapArrItem(chars, lo, i);
            permRec(chars, lo + 1);
            swapArrItem(chars, lo, i);
        }
        return null;
    }

    public List<String> find_permutation(String S) {
        permRec(S.toCharArray(), 0);
        return null;
    }

    public static void main(String[] args) {
        FindPermutation findPermutation = new FindPermutation();
        findPermutation.find_permutation("123");
    }
}
