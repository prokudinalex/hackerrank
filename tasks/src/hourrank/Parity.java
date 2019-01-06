package hourrank;

import java.util.Arrays;
import java.util.Scanner;

public class Parity {
    static int smallestSizeSubsequence(int n, int[] A) {
        long sum = Arrays.stream(A).sum();
        if (sum % 2 == 0) {
            return 0;
        }

        if (1 == n && A[0] % 2 != 0) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            int item = A[i];
            if (item % 2 != 0) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int result = smallestSizeSubsequence(n, A);
        System.out.println(result);
    }
}
