package com.app.dsa.part2.graph;


import java.util.*;

public class CityThresholdDis {

    static class Pair {
        int nei;
        int wt;

        public Pair(int nei, int wt) {
            this.nei = nei;
            this.wt = wt;
        }
    }

    static class CityPair {
        int city;
        int cityCount;

        public CityPair(int city, int cityCount) {
            this.city = city;
            this.cityCount = cityCount;
        }
    }

    int findCityUtil(int city, Map<Integer, List<Pair>> edges, int distanceThreshold) {

        int count = 0;
        List<Pair> nei = edges.get(city);
        for (Pair pair : nei) {
            if (pair.wt <= distanceThreshold) {
                count += findCityUtil(pair.nei, edges, distanceThreshold - pair.wt);
            }
        }
        return count;
    }

    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        //code here
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Pair> nei = map.getOrDefault(edge[0], new ArrayList<>());
            nei.add(new Pair(edge[1], edge[2]));
            map.put(edge[0], nei);

            List<Pair> nei2 = map.getOrDefault(edge[1], new ArrayList<>());
            nei2.add(new Pair(edge[0], edge[2]));
            map.put(edge[1], nei2);

        }

        Queue<CityPair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cityCount == o2.cityCount){
                return o2.city - o1.city;
            }
            return o1.cityCount - o2.cityCount;
        });

        for (Integer city : map.keySet()) {
            int cityCount = findCityUtil(city, map, distanceThreshold);
            pq.add(new CityPair(city, cityCount));
        }
        if (pq.isEmpty()) {
            return 0;
        }
        return pq.peek().city;
    }
}
