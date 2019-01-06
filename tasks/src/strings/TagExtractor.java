package strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtractor {

    private static void extract(String s) {
        Pattern p = Pattern.compile("<(.+)>([^<>\\/]+)<\\/\\1>");
        Matcher m = p.matcher(s);
        if (!m.find()) {
            System.out.println("None");
            return;
        }

        m.reset();

        while (m.find()) {
            System.out.println(m.group(2));
        }
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            extract(line);

            testCases--;
        }
    }
}
