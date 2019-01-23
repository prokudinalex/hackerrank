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
            double median = getMedian(window, d);
            //System.out.println(String.format("%f %s", median, window));

            if (expenditure[i] >= 2 * median) {
                result++;
            }

            if (i != n - 1) {
                moveWindow(window, d, expenditure[i], expenditure[i - d], median);
            }
        }
        return result;
    }

    private static void moveWindow(List<Integer> window, int d, int toAdd, int toRemove, double median) {
        // at first find element to remove and remove it
        int removeIndex = (toRemove > median) ? window.lastIndexOf(toRemove) : window.indexOf(toRemove);
        window.remove(removeIndex);

        int addIndex  = findAddIndex(window, d - 1, toAdd, median);
        window.add(addIndex, toAdd);
    }

    private static int findAddIndex(List<Integer> window, int d, int toAdd, double median) {
        if (toAdd < median) {
            for (int i = 0; i < d - 1; i++) {
                if (window.get(i + 1) > toAdd) {
                    return i;
                }
            }
            return d - 1;
        } else {
            for (int i = d; i > 1; i--) {
                if (window.get(i - 1) <= toAdd) {
                    return i;
                }
            }
        }
        return 0;
    }

    private static double getMedian(List<Integer> window, int d) {
        if (d % 2 == 1) {
            return window.get(d / 2);
        }
        return (window.get(d / 2) + window.get(d / 2 - 1)) / 2.0;
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
            items[i] = Integer.valueOf(strings[i]);
        }

        int result = activityNotifications(items, d);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.newLine();
        writer.close();
        scan.close();
    }
}
