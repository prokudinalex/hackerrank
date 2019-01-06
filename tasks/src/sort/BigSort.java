package sort;
import java.util.*;

public class BigSort {

    static List<String> sortBigIntegers(String[] src) {
        List<String> list = new ArrayList<>(Arrays.asList(src));
        list.sort((o1, o2) -> {
            Integer s1 = o1.length();
            Integer s2 = o2.length();

            if (s1.equals(s2)) {
                return o1.compareTo(o2);
            }

            return s1.compareTo(s2);
        });

        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        List<String> sorted = sortBigIntegers(unsorted);
        sorted.forEach(System.out::println);
    }
}