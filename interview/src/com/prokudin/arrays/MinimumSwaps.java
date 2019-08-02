package com.prokudin.arrays;

import java.util.Scanner;

public class MinimumSwaps {
    private static int minimumSwaps(int[] arr) {
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

    private static int swap(int[] arr, int src, int dst) {
        arr[src] = arr[src] + arr[dst];
        arr[dst] = arr[src] - arr[dst];
        arr[src] = arr[src] - arr[dst];
        return arr[src] - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int res = minimumSwaps(arr);
        System.out.println(res);
    }
}
