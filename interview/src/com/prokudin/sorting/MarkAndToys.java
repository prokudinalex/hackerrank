package com.prokudin.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    private static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int len = prices.length;
        int currentSum = 0;
        for (int i = 0; i < len; i++) {
            currentSum += prices[i];
            if (currentSum > k) {
                return i;
            }
            if (i == len - 1) {
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        scanner.close();

        int result = maximumToys(prices, k);
        System.out.println(result);
    }
}
