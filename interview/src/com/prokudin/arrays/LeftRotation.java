package com.prokudin.arrays;

import java.util.Scanner;

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        int len = a.length;
        int rot = d % len;

        if (0 == rot) {
            return a;
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++, rot++) {
            result[i] = a[rot];
            if (rot + 1 == len) {
                rot = -1;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
        scanner.close();
    }
}
