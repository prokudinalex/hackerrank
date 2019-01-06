package datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class JavaStack {

    private static Character getPair(char s) {
        switch (s) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return 0;
        }
    }

    private static boolean isCorrect(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ('{' == c || '(' == c || '[' == c) {
                stack.push(c);
            } else {
                Character popped = stack.poll();
                if (null == popped || !getPair(c).equals(popped)) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(isCorrect(sc.next()));
        }
    }
}
