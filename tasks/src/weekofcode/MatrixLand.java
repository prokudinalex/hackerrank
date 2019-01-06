package weekofcode;

import java.util.Scanner;

public class MatrixLand {

    private static int[] rowNeighbors = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] colNeighbors = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static boolean canBeVisited(int[][] a, int i, int j, int h, int w) {
        return i >= 0 && i < h      // in the borders and was not visited yet
                && j >= 0 && j < w
                && 1 == a[i][j];
    }

    private static void visitIsland(int[][] a, int i, int j, int h, int w) {
        // mark visit
        a[i][j] = -1;

        // find land near the cell and visit it as well
        for (int k = 0; k < 8; k++) { // go through all neighbors and try to visit
            if (canBeVisited(a, i + rowNeighbors[k], j + colNeighbors[k], h, w)) {
                visitIsland(a, i + rowNeighbors[k], j + colNeighbors[k], h, w);
            }
        }
    }

    private static int findIslands(int[][] a, int h, int w) {
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (1 == a[i][j]) { // not visited yet
                    visitIsland(a, i, j, h, w);
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                a[i][j] = in.nextInt();
            }
        }
        int result = findIslands(a, h, w);
        System.out.println(result);
        in.close();
    }
}
