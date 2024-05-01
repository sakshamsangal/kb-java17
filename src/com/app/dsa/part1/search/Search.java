package com.app.dsa.part1.search;

import com.app.dsa.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public int count = 1;

    public int getPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if (arr[start] <= arr[end]) return -1;
        while (start < end) {
            int mid = (start + end) / 2;

            // mid is in 1st array
            if (arr[0] <= arr[mid]) {
                start = mid + 1;
            }

            // mid is in 2nd array
            else {
                end = mid;
            }
        }
        return start;
    }

    int getFirst(int start, int end, int num) {
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long item = (long) mid * mid;
            if (item == num) return mid;
            if (item < num) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }


    public int mySqrt(int num) {
        return getFirst(0, num, num);
    }

    public int searchRotatedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return mid;

            // chances in which range target belongs to
            if (arr[start] < arr[mid]) {

                // 1st part is sorted
                // if target is in this range
                if (arr[start] <= target && target <= arr[mid]) {

                    // change end
                    end = mid - 1;
                }

                // may be target is in 2nd range
                else {
                    start = mid + 1;
                }
            }

            // 2nd part is sorted
            else {

                // check if target lies in this range
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                }

                // target not lie in sorted range
                else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    int searchInsert(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == item) {
                return mid;
            }
            if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int eq = 0;
        for (int num : nums) {
            if (num < target) smaller++;
            else if (num == target) eq++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < eq; i++) {
            list.add(smaller);
            smaller++;
        }
        return list;
    }

    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 == -1) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }
            }

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int findMin(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) return arr[start];
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[0] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // normal binary search program
    public int binarySearch(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == item) {
                return mid;
            } else if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int getFirst(int[] arr, int item) {
        int start = 0;
        int first = -1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == item) {
                first = mid;
                end = mid - 1;
            } else if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return first;
    }

    public int getLast(int[] arr, int item) {
        int start = 0;
        int last = -1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == item) {
                last = mid;
                start = mid + 1;
            } else if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{getFirst(nums, target), getLast(nums, target)};
    }

    public Pair ceilFloor(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;

        Pair pair = new Pair(-1, -1);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // hit
            if (arr[mid] == item) {
                pair.ceil = arr[mid];
                pair.floor = arr[mid];
                return pair;
            }

            // miss
            if (item < arr[mid]) {
                pair.ceil = arr[mid];
                end = mid - 1;
            } else {
                pair.floor = arr[mid];
                start = mid + 1;
            }
        }
        return pair;
    }


    public int getStrictCeilIndex(char[] arr, char item) {
        int ceil = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // miss
            if (item < arr[mid]) {
                ceil = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ceil;
    }

    // when arr.length is not allowed
    public boolean binarySearchInfinityArray(int[] arr, int item) {
        Bound.setBound(arr, item);
        int start = Bound.lower;
        int end = Bound.upper;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == item) return true;
            if (item < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    public boolean linearSearch(int[] arr, int key) {
        for (Integer item : arr) {
            if (item == key) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] arr = new int[]{0, 1, 5, 5, 5, 12};
        int first = search.getFirst(arr, 5);
        System.out.println("first = " + first);
    }

    public class Bound {
        public static int lower = 0;
        public static int upper = 2;

        public static void setBound(int[] arr, int item) {
            while (arr[upper] < item) {
                lower = upper;
                upper <<= 1;
            }
        }
    }

    // reverse order
    // public int linearSearch(int[] arr, int key) {
    //     for (int i = arr.length - 1; i > -1; i--) {
    //         if (arr[i] == key) return arr.length - 1 - i;
    //     }
    //     return -1;
    // }



    // reverse traversal
    // public boolean linearSearch(int[] arr, int key) {
    //     for(int i = arr.length - 1; i > -1; i--) {
    //         if (arr[i] == key) return true;
    //     }
    //     return false;
    // }
}



