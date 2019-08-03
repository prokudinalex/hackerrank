package com.prokudin.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudulentActivity {

    private static int activityNotifications(int[] expenditure, int d) {
        List<Integer> window = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            window.add(expenditure[i]);
        }
        Collections.sort(window);

        int result = 0;
        int n = expenditure.length;
        for (int i = d; i < n; i++) {
            int bound = getBound(window, d);

            if (expenditure[i] >= bound) {
                result++;
            }

            if (i != n - 1) {
                moveWindow(window, d, expenditure[i], expenditure[i - d]);
            }
        }
        return result;
    }

    private static void moveWindow(List<Integer> window, int d, int toAdd, int toRemove) {
        // at first find element to remove and remove it
        int removeIndex = Collections.binarySearch(window, toRemove);
        if (toAdd == toRemove) {
            return;
        }
        window.remove(removeIndex);

        int addIndex  = findAddIndex(window, toAdd);
        window.add(addIndex, toAdd);
    }

    private static int findAddIndex(List<Integer> window, int toAdd) {
        int index = Collections.binarySearch(window, toAdd);
        if (0 > index) {
            index = -index - 1;
        }

        return index;
    }

    private static int getBound(List<Integer> window, int d) {
        if (d % 2 == 1) {
            return window.get(d / 2) * 2;
        }
        return window.get(d / 2) + window.get(d / 2 - 1);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();
        int d = scan.nextInt();

        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = scan.nextInt();
        }
        scan.close();

        int result = activityNotifications(items, d);
        System.out.println(result);
    }
}
