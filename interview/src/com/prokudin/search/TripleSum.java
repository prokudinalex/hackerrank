package com.prokudin.search;

import java.util.Arrays;
import java.util.Scanner;

public class TripleSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lenA = scan.nextInt();
        int lenB = scan.nextInt();
        int lenC = scan.nextInt();

        int[] a = scanIntArray(scan, lenA);
        int[] b = scanIntArray(scan, lenB);
        int[] c = scanIntArray(scan, lenC);
        scan.close();

        long result = findTripletCount(a, b, c);
        System.out.println(result);
    }

    private static int[] scanIntArray(Scanner scan, int len) {
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = scan.nextInt();
        }
        return Arrays.stream(result).sorted().distinct().toArray();
    }

    private static long findTripletCount(int[] a, int[] b, int[] c) {
        // find how many elements in C >= then each element in B
        // and how many elements in A <= then each element in A
        long result = 0;
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while (bi < b.length) {
            while (ai < a.length && a[ai] <= b[bi]) {
                ai++;
            }

            while (ci < c.length && c[ci] <= b[bi]) {
                ci++;
            }

            result += (long) ai * (long) ci;
            bi++;
        }
        return result;
    }
}
