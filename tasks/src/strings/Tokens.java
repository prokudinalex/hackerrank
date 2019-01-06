package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokens {

    private static void writeTokens(String s) {
        Pattern reg = Pattern.compile("([A-Za-z]+)");
        Matcher m = reg.matcher(s);
        List<String> matches = new ArrayList<>();
        while (m.find()) {
            matches.add(m.group());
        }
        System.out.println(matches.size());
        for (String match : matches) {
            System.out.println(match);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        writeTokens(s);
        scan.close();
    }
}
