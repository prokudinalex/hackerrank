package com.prokudin.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);
        scanner.close();
    }
}
