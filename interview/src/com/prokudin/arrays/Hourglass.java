package com.prokudin.arrays;

import java.util.Scanner;

public class Hourglass {

    private static final Scanner scanner = new Scanner(System.in);

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i][j]
                        + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                max = sum > max ? sum : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] row = scanner.nextLine().split(" ");

            for (int j = 0; j < 6; j++) {
                int item = Integer.parseInt(row[j]);
                arr[i][j] = item;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);
    }
}
