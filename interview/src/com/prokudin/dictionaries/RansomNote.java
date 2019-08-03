package com.prokudin.dictionaries;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class RansomNote {

    private static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> words = new Hashtable<>();
        Arrays.stream(magazine).forEach(s ->
            words.put(s, words.getOrDefault(s, 0) + 1));

        for (String s : note) {
            Integer rest = words.computeIfPresent(s, (key, value) -> value >= 1 ? value - 1 : null);
            if (null == rest) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        String[] magazine = new String[m];
        for (int i = 0; i < m; i++) {
            magazine[i] = scanner.next();
        }

        String[] note = new String[n];
        for (int i = 0; i < n; i++) {
            note[i] = scanner.next();
        }
        scanner.close();

        checkMagazine(magazine, note);
    }
}
