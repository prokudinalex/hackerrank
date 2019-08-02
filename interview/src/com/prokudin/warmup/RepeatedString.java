package com.prokudin.warmup;

import java.util.Scanner;

public class RepeatedString {
    static long countLettersA(String s, long n) {
        int len = s.length();
        long fullWordSize = 0;
        long tailWordSize = 0;
        int tailSize = (int)(n % len);
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if ('a' == chars[i]) {
                fullWordSize++;
                if (0 != tailSize && i < tailSize) {
                    tailWordSize++;
                }
            }
        }

        return fullWordSize * (n / len) + tailWordSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        long result = countLettersA(s, n);
        System.out.println(result);
    }
}
