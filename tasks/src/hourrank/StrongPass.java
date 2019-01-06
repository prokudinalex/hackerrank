package hourrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPass {
    static int minimumNumber(int n, String password) {
        int result = 0;
        Pattern lower = Pattern.compile("([a-z]+)");
        Matcher m = lower.matcher(password);
        if (!m.find()) {
            result++;
        }

        Pattern upper = Pattern.compile("([A-Z]+)");
        m = upper.matcher(password);
        if (!m.find()) {
            result++;
        }

        Pattern number = Pattern.compile("([0-9]+)");
        m = number.matcher(password);
        if (!m.find()) {
            result++;
        }

        Pattern specials = Pattern.compile("([!@#$%^&*()\\-+]+)");
        m = specials.matcher(password);
        if (!m.find()) {
            result++;
        }

        if (result + n < 6) {
            result += 6 - (result + n);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
