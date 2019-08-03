package com.prokudin.dictionaries;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

    private static String twoStrings(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }
        for (char c : s2.toCharArray()) {
            set2.add(c);
        }
        set1.retainAll(set2);
        return set1.size() > 0 ? "YES" : "NO";
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int testCount = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < testCount; i++) {
            String s1 = scan.nextLine();
            String s2 = scan.nextLine();
            System.out.println(twoStrings(s1, s2));
        }
    }
}
