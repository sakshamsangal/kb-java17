package com.app.dsa.util;

import com.app.dsa.model.gfg.Node;

public class MyUtil {
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swapArrItem(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isVowel(Node node) {
        return (node.data == 'a' || node.data == 'e' || node.data == 'i' || node.data == 'o' || node.data == 'u');
    }
}
