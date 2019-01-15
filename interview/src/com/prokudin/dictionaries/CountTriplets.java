package com.prokudin.dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        long[] sum = {0};

        Map<Long, Long> tempTripletCount = new HashMap<>();
        Map<Long, Long> tripletCount = new HashMap<>();
        for (Long item : arr) {
            sum[0] += tripletCount.getOrDefault(item, 0L);

            if (tempTripletCount.containsKey(item)) {
                tripletCount.put(item * r,
                        tripletCount.getOrDefault(item * r, 0L) + tempTripletCount.get(item));
            }

            tempTripletCount.put(item * r, tempTripletCount.getOrDefault(item * r, 0L) + 1);
        }
        return sum[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nr[0]);
        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();
    }
}
