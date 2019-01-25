package com.prokudin.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {
    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            String s = r.readLine().trim();
            System.out.println(isValid(s));
        }
    }

    private static String isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        // count frequencies
        for (Character c : chars) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(Integer i : charMap.values()) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
        if (keys.length == 1) {
            return "YES";
        }

        if (keys.length == 2) {
            Arrays.sort(keys);
            if (freqMap.get(keys[1]) == 1 && keys[1] - keys[0] == 1 || freqMap.get(keys[0]) == 1) {
                return "YES";
            }
        }

        return "NO";
    }
}
