package com.prokudin.sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FraudulentActivity {

    static int activityNotifications(int[] expenditure, int d) {
        List<Integer> window = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            window.add(expenditure[i]);
        }
        Collections.sort(window);

        int result = 0;
        int n = expenditure.length;
        for (int i = d; i < n; i++) {
            int bound = getBound(window, d);
            //System.out.println(String.format("%f %s", median, window));

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

    public static void main(String[] args) throws IOException {
        String[] nd = scan.nextLine().split(" ");
        int n = Integer.valueOf(nd[0]);
        int d = Integer.valueOf(nd[1]);

        int[] items = new int[n];
        String[] strings = scan.nextLine().split(" ");
        scan.skip("(\r\n|[\n\r]?)");
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(strings[i]);
        }

        int result = activityNotifications(items, d);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.newLine();
        writer.close();
        scan.close();
    }
}
