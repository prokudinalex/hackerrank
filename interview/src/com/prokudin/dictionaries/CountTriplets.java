package com.prokudin.dictionaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountTriplets {
    private static long countTriplets(List<Long> arr, long r) {
        long sum = 0;

        Map<Long, Long> tempTripletCount = new HashMap<>();
        Map<Long, Long> tripletCount = new HashMap<>();
        for (Long item : arr) {
            sum += tripletCount.getOrDefault(item, 0L);

            if (tempTripletCount.containsKey(item)) {
                tripletCount.put(item * r,
                        tripletCount.getOrDefault(item * r, 0L) + tempTripletCount.get(item));
            }

            tempTripletCount.put(item * r, tempTripletCount.getOrDefault(item * r, 0L) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long r = scan.nextLong();

        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextLong());
        }
        scan.close();

        long ans = countTriplets(arr, r);
        System.out.println(ans);
    }
}
