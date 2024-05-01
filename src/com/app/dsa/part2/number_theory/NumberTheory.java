package com.app.dsa.part2.number_theory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberTheory {

    public int kthFactor(int n, int k) {

        int count = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (k == count) {
                return i;
            }
            if (i % 2 == 0) {
                count++;
            }
        }
        return -1;
    }

    public double binaryExp(double base, int power) {
        int n = Math.abs(power);
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                n--;
                result *= base;
            }
            // we have even n now
            n = n >> 1; // divide by 2
            base *= base;
        }
        if (power < 0) {
            return 1 / result;
        }
        return result;
    }

    Long squaresInChessBoard(Long N) {
//        return (long) (6 * n * (n + 1)* (2 * n + 1) - n *(n + 1) + Math.pow(N, 3));
        return N * (N + 1) / 6 * (2 * N + 1);
        // code here
    }

    public String fractionToDecimal(int numerator, int denominator) {
        int q = numerator / denominator;
        int r = numerator % denominator;

        StringBuilder ans = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        ans.append(q);
        if (r == 0) {
            return ans.toString();
        } else {
            ans.append(".");
            while (r != 0) {
                if (map.containsKey(r)) {
                    Integer i = map.get(r);
                    ans.insert(i, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(r, ans.length());
                    numerator = r * 10;
                    q = numerator / denominator;
                    r = numerator % denominator;
                    ans.append(q);
                }
            }
        }
        return ans.toString();
    }


    public void sieveOfEratosthenes(int upperLimit) {
        if (upperLimit < 2) {
            System.out.println("There are no prime numbers less than or equal to " + upperLimit);
            return;
        }
        boolean[] prime = new boolean[upperLimit + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= upperLimit; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) System.out.print(i + " ");
        }
    }

    public int trailingZeroes(int n) {
        n++;
        int count = 0;
        int lastDigit = 1;
        for (int i = 1; i < n; i++) {
            int f = lastDigit * i;
            System.out.println("lastDigit = " + lastDigit);
            lastDigit = f % 10;
            while (lastDigit == 0) {
                f = f / 10;
                lastDigit = f % 10;
                count++;
            }
        }
        return count;
    }


    public static int countSetBits(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;

            int k = i;
            while (k != 0) {
                k = k & (k - 1);
                count++;
            }
            sum += count;
        }
        return sum;
    }


    public static void main(String[] args) {
        NumberTheory numberTheory = new NumberTheory();
        int i = countSetBits(10);
        System.out.println("i = " + i);
    }
}
