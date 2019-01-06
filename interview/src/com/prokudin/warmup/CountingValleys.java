package com.prokudin.warmup;

import java.util.Scanner;

public class CountingValleys {
    static int countingValleys(int n, String s) {
        int result = 0;
        int level = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++) {
            int tmpLevel = level;
            level = 'D' == chars[i] ? level - 1 : level + 1;

            if (0 == level && tmpLevel < 0) {
                result++;
            }
        }
        return level < 0 ? result + 1 : result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);
        scanner.close();
    }
}
