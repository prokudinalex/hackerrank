package datastructures;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

    private static BitSet getOperand(int c1, BitSet a, BitSet b) {
        switch (c1) {
            case 1:
                return a;
            case 2:
                return b;
        }
        return a;
    }

    private static void handleCommand(String command, int c1, int c2, BitSet a, BitSet b) {
        BitSet left = getOperand(c1, a, b);
        BitSet right = getOperand(c2, a, b);
        switch (command) {
            case "AND":
                left.and(right);
                break;
            case "OR":
                left.or(right);
                break;
            case "XOR":
                left.xor(right);
                break;
            case "FLIP":
                left.flip(c2);
                break;
            case "SET":
                left.set(c2);
                break;
        }

        System.out.println(a.cardinality() + " " + b.cardinality());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        BitSet a = new BitSet(n);
        BitSet b = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String command = scan.next();
            int c1 = scan.nextInt();
            int c2 = scan.nextInt();
            handleCommand(command, c1, c2, a, b);
        }
    }
}
