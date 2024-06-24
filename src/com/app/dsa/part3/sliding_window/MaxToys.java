package com.app.dsa.part3.sliding_window;

import javax.management.Query;
import java.util.*;

public class MaxToys {

    // FIXME: 6/23/2024 not done
    ArrayList<Integer> maximumToys(int N, int cost[], int Q, ArrayList<Integer> queries[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(cost);
        for (ArrayList<Integer> query : queries) {
            int money = query.get(0);
            int brokenToysSize = query.get(1);

            Set<Integer> set = new HashSet<>();
            int j = 2;
            for (int i = 0; i < brokenToysSize; i++) {
                set.add(query.get(j++)-1);
            }

            List<Integer> okToys = new ArrayList<>();
            for (int i = 0; i < cost.length; i++) {
                if (!set.contains(i)) {
                    okToys.add(cost[i]);
                }
            }
            int c = 0;
            for (Integer okToy : okToys) {
                if (money >= okToy) {
                    money -= okToy;
                    c++;
                } else {
                    break;
                }
            }
            ans.add(c);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxToys maxToys = new MaxToys();
        int N = 5;
        int A[] = {8, 6, 9, 2, 5};
        int Q = 2;
        ArrayList<Integer>[] query = new ArrayList[Q];
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        query[0] = list1;
        maxToys.maximumToys(N, A, Q, query);
    }

}
