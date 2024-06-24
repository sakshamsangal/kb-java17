package com.app.dsa.part3.sliding_window;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInt {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] ans = new long[N-K+1];
        int k = 0;
        Queue<Long> queOfNeg = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                queOfNeg.add(A[i]);
            }
        }
        if (queOfNeg.isEmpty()) {
            ans[k++] = 0;
        } else {
            ans[k++] = queOfNeg.peek();
        }

        int j = 0;
        for (int i = K; i < N; i++) {
            //remove
            if (A[j] < 0) {
                queOfNeg.poll();
            }
            if (A[i] < 0) {
                queOfNeg.add(A[i]);
            }
            if (queOfNeg.isEmpty()) {
                ans[k++] = 0;
            } else {
                ans[k++] = queOfNeg.peek();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FirstNegativeInt firstNegativeInt = new FirstNegativeInt();
        long A[] = {48,974,5,-59,-451};
        firstNegativeInt.printFirstNegativeInteger(A, 5,3);
    }
}
