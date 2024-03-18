package diagonalDiference;

import java.util.*;

public class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int primeraDiagonal = 0;
        int segundaDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    primeraDiagonal += arr.get(i).get(j);
                }
                if (i + j == arr.size() - 1) {
                    segundaDiagonal += arr.get(i).get(j);
                }
            }
        }
        return Math.abs(primeraDiagonal - segundaDiagonal);
    }

}