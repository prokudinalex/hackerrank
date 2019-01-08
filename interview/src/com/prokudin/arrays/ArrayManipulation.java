package com.prokudin.arrays;

import java.util.Scanner;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        // will keep only difference between i and i-1 elements
        // so will not need to track the whole interval, as middle difference will = 0
        long[] diffs = new long[n];
        int queriesCount = queries.length;
        long max = Long.MIN_VALUE;
        for (int q = 0; q < queriesCount; q++) {
            int left = queries[q][0] - 1;
            int right = queries[q][1] - 1;
            diffs[left] += queries[q][2];
            if (right + 1 < n) {
                diffs[right + 1] -= queries[q][2];
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        scanner.close();
    }
}
