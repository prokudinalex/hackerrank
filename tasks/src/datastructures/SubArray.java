package datastructures;

import java.util.Scanner;

public class SubArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            if (a[i] < 0) {
                //System.out.printf("[%d]%n", i);
                result++;
            }
        }

        for (int size = 2; size <= n; size++) {
            for (int begin = 0; begin < n - size + 1; begin++) {
                int sum = 0;
                for (int i = begin; i < begin + size; i++) {
                    sum += a[i];
                }
                if (sum < 0) {
                    //System.out.printf("[%d;%d]%n", begin, begin + size - 1);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
