package weekofcode;

import java.util.Scanner;

public class HighwayConstruction {
    private static int M = 1000000009;

    private static int highwayConstruction(long n, int k) {
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            result += getPower(n - i, k);
        }
        return result;
    }

    private static int getPower(long n, int k) {
        int v = (int) n % M;
        char[] binaryPow = getBinaryRepresentation(k);
        int len = binaryPow.length;
        int result = (int) n % M;
        for (int i = 1; i < len; i++) {
            if ('1' == binaryPow[i]) {
                result = (result * result * v) % M;
            } else {
                result = (result * result) % M;
            }
        }
        return result;
    }

    private static char[] getBinaryRepresentation(int k) {
        String s = Integer.toString(k, 2);
        return s.toCharArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            int k = in.nextInt();
            int result = highwayConstruction(n, k);
            System.out.println(result);
        }
        in.close();
    }
}
