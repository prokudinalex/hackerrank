import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getNext(int grade) {
        return 0 == grade % 5 ? grade : (grade / 5 + 1) * 5;
    }

    static int round(int grade) {
        if (grade < 38) {
            return grade;
        }
        int next = getNext(grade);
        if (next - grade > 0 && next - grade < 3) {
            return next;
        }
        return grade;
    }

    static int[] solve(int[] grades){
        int[] result = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            result[i] = round(grades[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}
