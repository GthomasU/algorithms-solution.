package UvaOnlineJudge.problem100;

import java.util.*;

class Main {

    public static void main(String... args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                int k = solve(i, j);
                System.out.println(String.format("%d %d %d", i, j, k));
            }
            sc.close();
        } catch (Exception e) {

        } finally {

            System.exit(0);
        }

    }

    private static int solve(int i, int j) {
        int mayor = 0;
        for (int k = Math.min(i, j); k <= Math.max(i, j); k++) {
            int count = calculate(k);
            if (count > mayor) {
                mayor = count;
            }
        }

        return mayor;
    }

    private static int calculate(int n) {
        int count = 1;
        while (n != 1) {
            count++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n * 3) + 1;
            }
        }
        return count;

    }

}