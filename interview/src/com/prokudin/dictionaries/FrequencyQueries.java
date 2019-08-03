package com.prokudin.dictionaries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class FrequencyQueries {
    private static Map<Integer, Integer> values = new HashMap<>();
    private static Map<Integer, Integer> frequencies = new HashMap<>();
    private static List<Integer> results = new ArrayList<>();

    private static void performAction(int action, int val) {
        Integer oldFreq, newFreq, oldVal, newVal;
        if (3 == action) {
            results.add(frequencies.containsKey(val) ? 1 : 0);
        } else {
            oldFreq = values.getOrDefault(val, 0);
            oldVal = frequencies.getOrDefault(oldFreq, 0);

            newFreq = (1 == action) ? oldFreq + 1 : oldFreq - 1;
            newVal = frequencies.getOrDefault(newFreq, 0);

            if (1 > newFreq) {
                values.remove(val);
            } else {
                values.put(val, newFreq);
            }

            if (1 > oldVal - 1) {
                frequencies.remove(oldFreq);
            } else {
                frequencies.put(oldFreq, oldVal - 1);
            }
            frequencies.put(newFreq, newVal + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(bufferedReader);

        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int action = scan.nextInt();
            int val = scan.nextInt();
            performAction(action, val);
        }
        scan.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(results.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n");
        bufferedWriter.close();
    }
}
