package weekofcode;

import java.util.*;

public class MatrixLand2 {

    private static class ValuableOuts {
        int value = -251;
        Set<Integer> outs = new HashSet<>();
    }

    private static void checkMaxPath(int value, int out, ValuableOuts vouts) {
        if (vouts.value < value) {
            vouts.outs.clear();
            vouts.value = value;
            vouts.outs.add(out);
        } else if (vouts.value == value) {
            vouts.outs.add(out);
        }
    }

    private static void traceVisitedMatrix(int[] a, int in, ValuableOuts outs) {
        int n = a.length;

        // row means out cell
        // col means visited cell
        int[][] matrix = new int[n][n];
        matrix[in][in] = a[in];

        // fill main col
        for (int i = in + 1; i < n; i++) {
            matrix[i][in] = a[i] + matrix[i - 1][in];
            checkMaxPath(matrix[i][in], i, outs);
        }
        for (int i = in - 1; i >= 0; i--) {
            matrix[i][in] = a[i] + matrix[i + 1][in];
            checkMaxPath(matrix[i][in], i, outs);
        }

        // fill other cols
        for (int j = in + 1; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int min = Math.min(i, in);
                int max = Math.max(i, in);
                matrix[i][j] = matrix[i][j - 1] + (j < min || j > max ? a[j] : 0);
                checkMaxPath(matrix[i][j], i, outs);
            }
        }
        for (int j = in - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int min = Math.min(i, in);
                int max = Math.max(i, in);
                matrix[i][j] =  matrix[i][j + 1] + (j < min || j > max ? a[j] : 0);
                checkMaxPath(matrix[i][j], i, outs);
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (j < n - 1) {
//                    System.out.print(matrix[i][j] + " ");
//                } else {
//                    System.out.println(matrix[i][j]);
//                }
//            }
//        }
    }

    private static ValuableOuts getInitialOuts(int[] a) {
        ValuableOuts outs = new ValuableOuts();
        int len = a.length;
        for (int i = 0; i < len; i++) {
            traceVisitedMatrix(a, i, outs);
        }

//        System.out.println("Maximum path: " + outs.value);
//        System.out.println("Outs: " + outs.outs);
        return outs;
    }

    private static ValuableOuts findMostValuableOuts(int[] array, ValuableOuts inputs) {
        ValuableOuts result = new ValuableOuts();
        for (Integer i : inputs.outs) {
            ValuableOuts vouts = new ValuableOuts();
            traceVisitedMatrix(array, i, vouts);

            if (result.value < vouts.value) {
                result = vouts;
            }
        }

//        System.out.println("Maximum path: " + result.value);
//        System.out.println("Outs: " + result.outs);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] A = new int[n][m];

        int totalResult = 0;
        ValuableOuts outs1 = new ValuableOuts();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                A[i][j] = in.nextInt();
            }

            if (0 == i) {
                outs1 = getInitialOuts(A[i]);
                totalResult += outs1.value;
            } else {
                ValuableOuts outs2 = findMostValuableOuts(A[i], outs1);
                totalResult += outs2.value;
                outs1 = outs2;
            }
        }
        System.out.println(totalResult);
        in.close();
    }
}
