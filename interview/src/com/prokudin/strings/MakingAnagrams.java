package com.prokudin.strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MakingAnagrams {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String a = scan.nextLine().trim();
        String b = scan.nextLine().trim();
        System.out.println(countAnagramDiff(a, b));
    }

    private static int countAnagramDiff(String a, String b) {
        Map<Character, Integer> aLetters = new HashMap<>();
        Map<Character, Integer> bLetters = new HashMap<>();
        for (char c : a.toCharArray()) {
            aLetters.put(c, aLetters.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            bLetters.put(c, bLetters.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> collect = Stream.of(aLetters, bLetters).map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (x, y) -> Math.abs(x - y)));
        return collect.values().stream().mapToInt(Integer::intValue).sum();
    }
}
