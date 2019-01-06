package datastructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        int result = 0;
        Set<String> pairs = new HashSet<>();
        for (int i = 0; i < t; i++) {
            String pair = pair_left[i] + "_" + pair_right[i];
            if (!pairs.contains(pair)) {
                pairs.add(pair);
                result++;
            }
            System.out.println(result);
        }
    }
}
