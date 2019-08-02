package com.prokudin.arrays;

import java.util.Scanner;

public class ArrayManipulation {
    private static long arrayManipulation(int n, int[][] queries) {
        // will keep only difference between i and i-1 elements
        // so will not need to track the whole interval, as middle difference will == 0
        long[] diffs = new long[n];
        int queriesCount = queries.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < queriesCount; i++) {
            int left = queries[i][0] - 1;
            int right = queries[i][1] - 1;
            diffs[left] += queries[i][2];
            if (right + 1 < n) {
                diffs[right + 1] -= queries[i][2];
            }
        }

        // just need to sum up diffs and check the max
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += diffs[i];
            max = tmp > max ? tmp : max;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                int queriesItem = scanner.nextInt();
                queries[i][j] = queriesItem;
            }
        }
        scanner.close();

        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}
