package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    private static Map<String, Integer> book = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for(int i = 0; i<n; i++) {
            book.put(in.nextLine(), in.nextInt());
            in.nextLine();
        }

        while(in.hasNext()) {
            String s = in.nextLine();
            Integer v = book.get(s);
            if (null == v) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + v);
            }
        }
    }
}
