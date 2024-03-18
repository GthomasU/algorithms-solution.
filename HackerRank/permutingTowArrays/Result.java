package permutingTowArrays;

import java.util.*;

public class Result {

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B);
        for (int i = 0; i < A.size(); i++)
            if (A.get(i) + B.get(i) < k)
                return "NO";

        return "YES";

    }

    public static String twoArrays1(int k, List<Integer> A, List<Integer> B) {
        List<Integer> excluided = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                Integer sum = A.get(i) + B.get(j);
                if (sum >= k && !isExcluided(j, excluided)) {
                    excluided.add(j);
                    break;
                }
            }
        }
        System.out.println(excluided.size());
        if (excluided.size() == B.size()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static boolean isExcluided(Integer n, List<Integer> exluided) {
        for (int i = 0; i < exluided.size(); i++) {
            if (exluided.get(i) == n) {
                return true;
            }
        }
        return false;
    }
}
