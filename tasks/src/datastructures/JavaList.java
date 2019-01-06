package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }

        int q = scan.nextInt();
        for (int i = 0; i <  q; i ++) {
            String action = scan.next();
            if ("Insert".equals(action)) {
                list.add(scan.nextInt(), scan.nextInt());
            } else {
                list.remove(scan.nextInt());
            }
        }

        System.out.println(list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
