package com.prokudin.sorting;

import java.util.Scanner;

public class BubbleSort {

    private static void countSwaps(int[] a) {
        int n = a.length;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaps++;
                }
            }
        }
        System.out.println(String.format("Array is sorted in %d swaps.%n" +
                "First Element: %d%n" +
                "Last Element: %d%n", swaps, a[0], a[a.length - 1]));
    }

    private static void swap(int[] a, int i, int j) {
        if (i >= 0 && i < a.length
            && j >= 0 && j < a.length) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        countSwaps(a);
    }
}
