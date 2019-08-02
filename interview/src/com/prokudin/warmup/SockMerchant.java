package com.prokudin.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    static int findPairs(int n, int[] ar) {
        final int[] result = { 0 };
        Map<Integer, Integer> pairs = new HashMap<>();
        Arrays.stream(ar).forEach(item -> {
            pairs.put(item, pairs.getOrDefault(item, 0) + 1);
            if (0 == pairs.get(item) % 2) {
                result[0]++;
            }
        });
        return result[0];
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        System.out.println(findPairs(n, ar));
    }
}
