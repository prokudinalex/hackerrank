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

import static java.util.stream.Collectors.joining;

public class FrequencyQueries {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> valuesToFreqMap = new HashMap<>();
        Map<Integer, Integer> freqToValuesMap = new HashMap<>();

        Integer oldFreq, newFreq, oldVal, newVal;
        int c, v;
        List<Integer> results = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                c = Integer.valueOf(query[0]);
                v = Integer.valueOf(query[1]);

                if (3 == c) {
                        results.add(freqToValuesMap.containsKey(v) ? 1 : 0);
                } else {
                    oldFreq = valuesToFreqMap.getOrDefault(v, 0);
                    oldVal = freqToValuesMap.getOrDefault(oldFreq, 0);

                    newFreq = (1 == c) ? oldFreq + 1 : oldFreq - 1;
                    newVal = freqToValuesMap.getOrDefault(newFreq, 0);

                    if (1 > newFreq) {
                        valuesToFreqMap.remove(v);
                    } else {
                        valuesToFreqMap.put(v, newFreq);
                    }

                    if (1 > oldVal - 1) {
                        freqToValuesMap.remove(oldFreq);
                    } else {
                        freqToValuesMap.put(oldFreq, oldVal - 1);
                    }
                    freqToValuesMap.put(newFreq, newVal + 1);
                }
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bufferedWriter.write(results.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                    + "\n");
        }
    }
}
