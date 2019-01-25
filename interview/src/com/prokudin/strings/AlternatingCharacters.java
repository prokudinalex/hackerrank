package com.prokudin.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCharacters {

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(r.readLine().trim());
            for (int i = 0; i < q; i++) {
                System.out.println(countDeletions(r.readLine().trim()));
            }
        }
    }

    private static int countDeletions(String s) {
        char[] arr = s.toCharArray();
        char prev = Character.MIN_VALUE;
        int result = 0;
        for (char c : arr) {
            if (c == prev) {
                result++;
            }
            prev = c;
        }
        return result;
    }
}
