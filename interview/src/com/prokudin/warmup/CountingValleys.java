package com.prokudin.warmup;

import java.util.Scanner;

public class CountingValleys {
    private static int countValleys(int n, String s) {
        int result = 0;
        int level = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++) {
            int lastLevel = level;
            level = 'D' == chars[i] ? level - 1 : level + 1;

            // if we just hit sea level from the down - increment valleys
            if (0 == level && lastLevel < 0) {
                result++;
            }
        }

        // don't forget about last valley, if we still there
        return level < 0 ? result + 1 : result;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        scanner.close();

        int result = countValleys(n, s);
        System.out.println(result);
    }
}
