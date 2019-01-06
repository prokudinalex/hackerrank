package hourrank;

import java.util.Scanner;

public class DivideOnThree {
    static String canConstruct(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i);
        }
        int size = sb.length();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            long number = Long.parseLong(sb.charAt(i) + "");
            sum += number;
        }
        return sum % 3 == 0 ? "Yes" : "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = canConstruct(a);
            System.out.println(result);
        }
        in.close();
    }
}
