package weekofcode;

import java.util.Scanner;

public class SurfaceArea {

    private static int getNeighborValue(int[][] a, int i, int j, int h, int w) {
        int result = 0;

        // down
        if (i - 1 < 0) { // border
            result += a[i][j];
        } else if (a[i][j] > a[i - 1][j]) {
            result += a[i][j] - a[i - 1][j];
        }

        // up
        if (i + 1 >= h) { // border
            result += a[i][j];
        } else if (a[i][j] > a[i + 1][j]) {
            result += a[i][j] - a[i + 1][j];
        }

        // left
        if (j - 1 < 0) { // border
            result += a[i][j];
        } else if (a[i][j] > a[i][j - 1]) {
            result += a[i][j] - a[i][j - 1];
        }

        // right
        if (j + 1 >= w) { // border
            result += a[i][j];
        } else if (a[i][j] > a[i][j + 1]) {
            result += a[i][j] - a[i][j + 1];
        }

        return result;
    }

    private static int surfaceArea(int[][] a, int h, int w) {
        int result = h * w * 2;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result += getNeighborValue(a, i, j, h, w);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for (int A_i = 0; A_i < H; A_i++){
            for (int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A, H, W);
        System.out.println(result);
        in.close();
    }
}
