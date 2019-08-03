package com.prokudin.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for (int i = 0; i < testCount; i++) {
            int money = scan.nextInt();
            int n = scan.nextInt();
            int[] costs = new int[n];
            for (int j = 0; j < n; j++) {
                costs[j] = scan.nextInt();
            }

            printFlavourPair(costs, money);
        }
        scan.close();
    }

    private static void printFlavourPair(int[] costs, int money) {
        int size = costs.length;

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (indexMap.containsKey(costs[i])) {
                System.out.println(String.format("%d %d", indexMap.get(costs[i]) + 1, i + 1));
                return;
            }

            int potentialPair = money - costs[i];
            indexMap.put(potentialPair, i);
        }
        indexMap.clear();
    }
}
