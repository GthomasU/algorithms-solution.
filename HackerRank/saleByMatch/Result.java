package saleByMatch;

import java.util.*;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        Collections.sort(ar);
        HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (counters.get(ar.get(i)) == null) {
                counters.put(ar.get(i), 1);
            } else {
                counters.put(ar.get(i), counters.get(ar.get(i)) + 1);
            }
        }
        for (Integer integer : counters.keySet()) {
            count += counters.get(integer) / 2;
        }

        return count;
        // Write your code here

    }

}