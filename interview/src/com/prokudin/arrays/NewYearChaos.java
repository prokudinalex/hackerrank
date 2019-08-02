package com.prokudin.arrays;

import java.util.Scanner;

public class NewYearChaos {
    private static void minimumBribes(int[] q) {
        int len = q.length;
        int result = 0;

        // count amount of persons which bribed current element
        for (int i = 0; i < len; i++) {
            int bribe = q[i] - i - 1;
            if (bribe > 2) {
                System.out.println("Too chaotic");
                return;
            }
            int place = q[i] - 2 > 0 ? q[i] - 2 : 0;
            for (int j = place; j < i; j++) {
                if (q[j] > q[i]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        for (int test = 0; test < testCount; test++) {
            int n = scanner.nextInt();
            int[] q = new int[n];
            for (int i = 0; i < n; i++) {
                q[i] = scanner.nextInt();
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
