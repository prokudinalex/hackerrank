package com.prokudin.warmup;

import java.util.Scanner;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        int result = 0;
        int[] pairs = new int[100];
        for(int i = 0; i < n; i++) {
            pairs[ar[i] - 1]++;
            if (pairs[ar[i] - 1] % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);

        scanner.close();
    }
}
