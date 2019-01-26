package com.prokudin.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialPalindromicString {
    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(r.readLine().trim());
            String s = r.readLine().trim();
            System.out.println(substrCount(n, s));
        }
    }

    private static long substrCount(int n, String s) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            int innerCounter = 1;

            int counterDown = 0;
            int counterUp = 1;
            // count same chars
            while (i - innerCounter >= 0 && i + innerCounter < n
                    && s.charAt(i - innerCounter) == s.charAt(i - 1) && s.charAt(i + innerCounter) == s.charAt(i - 1)) {
                count++;
                innerCounter++;
            }

            // count except middle
            while (i - counterDown >= 0 && i + counterUp < n && s.charAt(i - counterDown) == s.charAt(i)
                    && s.charAt(i + counterUp) == s.charAt(i)) {
                count++;
                counterDown++;
                counterUp++;
            }
        }

        return count + n;
    }
}
