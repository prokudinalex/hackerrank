package com.prokudin.dictionaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagrams {

    private static int sherlockAndAnagrams(String s) {
        // find all substrings of each length and their pairs
        int totalPairs = 0;
        for (int i = 1; i <= s.length(); i++) {
            int pairs = findSubstringsOfLength(s, i);
            totalPairs += pairs;
        }
        return totalPairs;
    }

    private static int findSubstringsOfLength(String s, int len) {
        int stringSize = s.length();
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i + len <= stringSize; i++) {
            substrings.add(s.substring(i, i + len));
        }

        return findPairs(substrings.toArray(new String[0]));
    }

    private static int findPairs(String[] strings) {
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (isAnagram(strings[i], strings[j])) {
                    //System.out.println(String.format("Pair: %s %s", strings[i], strings[j]));
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = getCharacterMap(s1);
        Map<Character, Integer> map2 = getCharacterMap(s2);

        return map1.equals(map2);
    }

    private static Map<Character, Integer> getCharacterMap(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            result.compute(c, (key, value) -> {
                if (null == value) {
                    return 1;
                }
                return value + 1;
            });
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
        scanner.close();
    }
}
