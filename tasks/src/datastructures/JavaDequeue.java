package datastructures;

import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> uniques = new HashSet<>();
        long max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addFirst(num);
            uniques.add(num);

            if (m == deque.size()) {
                if (uniques.size() > max) {
                    max = uniques.size();
                }

                int last = deque.removeLast();
                if (!deque.contains(last)) {
                    uniques.remove(last);
                }
            }
        }

        System.out.println(max);
    }
}
