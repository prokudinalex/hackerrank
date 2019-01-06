package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        String a_lower = a.toLowerCase();
        String b_lower = b.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a_lower.length(); i++) {
            char ac = a_lower.charAt(i);
            char bc = b_lower.charAt(i);
            aggregate(ac, map);
            aggregate(bc, map);
        }

        for (Integer i : map.values()) {
            System.out.println(i);
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private static void aggregate(char c, Map<Character, Integer> map) {
        map.compute(c, (k, v) -> null == v ? 1 : v + 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
