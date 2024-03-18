package coutingsort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> counters = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            counters.add(Integer.valueOf(0));
        }
        for (int i = 0; i < 100; i++) {
            // counters.set(arr.get(i).intValue(),
            // Integer.valueOf(counters.get(i).intValue() + 1));
            int count = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j) == i) {
                    count++;
                }
            }
            counters.set(i, Integer.valueOf(count));

        }
        System.out.println(counters.size());
        return counters;

    }

}
