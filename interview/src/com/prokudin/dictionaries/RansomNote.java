package com.prokudin.dictionaries;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> words = new Hashtable<>();
        Arrays.stream(magazine).forEach(s ->
            words.compute(s, (key, value) -> {
                if (null == value) {
                    return 1;
                }
                return value + 1;
            }));

        for (String s : note) {
            Integer rest = words.computeIfPresent(s, (key, value) -> value >= 1 ? value - 1 : null);
            if (null == rest) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
