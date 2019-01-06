package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            int size = scan.nextInt();
            for (int j = 0; j < size; j++) {
                arr.add(scan.nextInt());
            }
            arrays.add(arr);
        }

        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int arr = scan.nextInt();
            int item = scan.nextInt();

            if (arr - 1 >= arrays.size()) {
                System.out.println("ERROR!");
                continue;
            }

            List<Integer> array = arrays.get(arr - 1);
            if (item - 1 >= array.size()) {
                System.out.println("ERROR!");
                continue;
            }

            System.out.println(array.get(item - 1));
        }
    }
}
