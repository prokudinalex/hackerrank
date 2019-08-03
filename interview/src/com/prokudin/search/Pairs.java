package com.prokudin.search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        Set<Long> elements = new HashSet<>();
        Set<Long> potentialPairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            long element = scan.nextLong();
            elements.add(element);
            potentialPairs.add(element + k);
        }
        scan.close();

        elements.retainAll(potentialPairs);
        System.out.println(elements.size());
    }
}
