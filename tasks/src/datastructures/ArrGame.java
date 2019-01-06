package datastructures;

import java.util.Scanner;

public class ArrGame {

    private static boolean isSolvable(int i, int leap, int[] game) {
        if (i < 0 || 1 == game[i]) { // if visited
            return false;
        }
        if (game.length - 1 == i || i + leap > game.length - 1) {
            return true;
        }

        // mark as visited
        game[i] = 1;
        return isSolvable(i + 1, leap, game)        // try forward
                || isSolvable(i - 1, leap, game)    // try backward
                || isSolvable(i + leap, leap, game);// try to leap
    }

    private static boolean canWin(int leap, int[] game) {
        return isSolvable(0, leap, game);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
