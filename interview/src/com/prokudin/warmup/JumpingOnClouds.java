package com.prokudin.warmup;

import java.util.Scanner;

public class JumpingOnClouds {
    static int jumpingOnClouds(int[] c) {
        int jumps = -1;
        int n = c.length;
        for (int i = 0; i < n; i++, jumps++) {
            if (i < n - 2 &&
                    (c[i + 1] == 1 || c[i + 1] == 0 && c[i + 2] == 0)) { // jump over
                i++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);
    }
}
