package com.prokudin.arrays;

import java.util.Scanner;

public class MinimumSwaps {
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        int result = 0;

        // how many swaps are needed (minimum) to have initial array
        for (int i = 0; i < len; i++) {
            int swapped = arr[i] - 1;
            while (swapped != i) {
                swapped = swap(arr, i, swapped);
                result++;
            }
        }
        return result;
    }

    static int swap(int[] arr, int src, int dst) {
        arr[src] = arr[src] + arr[dst];
        arr[dst] = arr[src] - arr[dst];
        arr[src] = arr[src] - arr[dst];
        return arr[src] - 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }
}
