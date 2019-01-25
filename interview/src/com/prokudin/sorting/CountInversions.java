package com.prokudin.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) throws IOException {
        List<Long> answers = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            int d = Integer.parseInt(r.readLine().trim());
            for (int i = 0; i < d; i++) {
                int n = Integer.parseInt(r.readLine().trim());
                Integer[] values = Arrays.stream(r.readLine().trim().split(" "))
                        .map(Integer::parseInt).toArray(Integer[]::new);
                answers.add(countInversions(values));
            }
        }


        answers.forEach(System.out::println);
    }

    private static long countInversions(Integer[] arr) {
        return mergeSort(arr, new Integer[arr.length], 0, arr.length - 1);
    }

    private static long mergeSort(Integer[] arr, Integer[] tmp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return 0;
        }

        int middle = (leftStart + rightEnd) / 2;
        long result = 0;
        result += mergeSort(arr, tmp, leftStart, middle);
        result += mergeSort(arr, tmp, middle + 1, rightEnd);
        result += mergeHalves(arr, tmp, leftStart, rightEnd);
        return result;
    }

    private static long mergeHalves(Integer[] arr, Integer[] tmp, int leftStart, int rightEnd) {
        long inversions = 0;
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;

        int left = leftStart;
        int right = rightStart;
        int i = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                tmp[i] = arr[left];
                left++;
            } else {
                tmp[i] = arr[right];
                right++;
                inversions += leftEnd - left + 1;
            }
            i++;
        }

        System.arraycopy(arr, left, tmp, i, leftEnd - left + 1);
        System.arraycopy(arr, right, tmp, i, rightEnd - right + 1);
        System.arraycopy(tmp, leftStart, arr, leftStart, rightEnd - leftStart + 1);

        return inversions;
    }
}
