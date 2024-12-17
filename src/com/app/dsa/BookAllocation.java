package com.app.dsa;

import java.util.Arrays;

public class BookAllocation {
    public int findPages(int[] books, int studCount) {
        if (studCount>books.length){
            return -1;
        }
        int lowLimit = Arrays.stream(books).max().orElse(1);
        int highLimit = Arrays.stream(books).sum();

        int ans = lowLimit;

        while (lowLimit <= highLimit) {
            int studWhichAreConsumed = 1;
            int totalPages = 0;
            int mid = lowLimit + (highLimit - lowLimit) / 2;
            for (int book : books) {
                if (totalPages + book <= mid) {
                    totalPages = totalPages + book;
                } else {
                    studWhichAreConsumed++;
                    totalPages = book;
                }
            }
            if (studWhichAreConsumed > studCount) {
                // change lowLimit
                lowLimit = mid + 1;
            } else {
                ans = mid;
                highLimit = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BookAllocation bookAllocation = new BookAllocation();
        int[] arr = {12, 34, 67, 90};
        int pages = bookAllocation.findPages(arr, 2);
        System.out.println("pages = " + pages);
    }
}