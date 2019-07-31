package com.prokudin.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChild {
    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = r.readLine().trim();
            String s2 = r.readLine().trim();
            System.out.println(countChild(s1, s2));
        }
    }

    private static int countChild(String s1, String s2) {
        if (0 == s1.length() || 0 == s2.length()) {
            return 0;
        }

        // find last common letter
        char last1 = s1.charAt(s1.length() - 1);
        int index1 = s2.lastIndexOf(last1);

        char last2 = s2.charAt(s2.length() - 1);
        int index2 = s1.lastIndexOf(last2);

        String ss1 = s1.length() - 1 > 0 ? s1.substring(0, s1.length() - 1) : "";
        String ss2 = s2.length() - 1 > 0 ? s2.substring(0, s2.length() - 1) : "";

        if (-1 == index1 && -1 == index2) {
            return countChild(ss1, ss2);
        } else if (-1 == index1) {
            return countChild(ss1, s2);
        } else if (-1 == index2) {
            return countChild(s1, ss2);
        }

        if (index1 > index2) {
            return Math.max(countChild(ss1, s2.substring(0, index1)) + 1, countChild(ss1, s2));
        }
        return Math.max(countChild(s1.substring(0, index2), ss2) + 1, countChild(s1, ss2));
    }

}
