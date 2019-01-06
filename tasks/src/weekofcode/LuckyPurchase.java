package weekofcode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LuckyPurchase {
    private static final Pattern p = Pattern.compile("^[4|7]+$");

    private static boolean isLuckyPrice(String price) {
        Matcher m = p.matcher(price);
        if (!m.matches()) {
            return false;
        }

        int n = price.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = price.charAt(i);
            if ('4' == c) {
                count++;
            } else {
                count--;
            }
        }

        return 0 == count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String result = "";
        Integer min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            String name = in.next();
            Integer price = in.nextInt();

            if (isLuckyPrice(price.toString())
                    && min > price) {
                min = price;
                result = name;
            }
        }
        in.close();

        System.out.println(Integer.MAX_VALUE == min ? -1 : result);
    }
}
