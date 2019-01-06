package weekofcode;

import java.util.Scanner;

public class TripleRecursion {

    private static void tripleRecursion(int n, int m, int k) {
        int[] matrix = new int[n * n];

        int diag = m;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    matrix[i * n + j] = diag;
                    diag += k;
                } else {
                    matrix[i * n + j] = diag - k - j + i;
                    matrix[j * n + i] = matrix[i * n + j];
                }
            }

            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    System.out.print(matrix[i * n + j] + " ");
                } else {
                    System.out.println(matrix[i * n + j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        tripleRecursion(n, m, k);
        in.close();
    }
}
