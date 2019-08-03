package com.prokudin.sorting;

import java.util.*;

public class PlayerComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (Player player1 : player) {
            System.out.printf("%s %s\n", player1.name, player1.score);
        }
    }

    private static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    private static class Checker implements Comparator<Player> {
        // complete this method
        public int compare(Player a, Player b) {
            int result = Integer.compare(b.score, a.score);
            if (0 == result) {
                // it's stated that player always has a name, so it can't be null
                // in other case it's better to use StringUtils.compare avoiding NullPointerException
                result = a.name.compareTo(b.name);
            }
            return result;
        }
    }
}
