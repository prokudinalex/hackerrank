package com.prokudin.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LeftRotation {
    private static int[] rotate(int[] a, int d) {
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
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int[] result = rotate(a, d);
        String resultJoined = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(resultJoined);
    }
}
