package UvaOnlineJudge.problem10137;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            List<Double> bills = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                bills.add(sc.nextDouble());
            }
            double output = solve(bills);
            System.out.printf("$%.2f%n", output);
        }
        sc.close();

        System.exit(0);
    }

    private static double solve(List<Double> bills) {
        double avg = getAverage(bills);
        double sumPos = 0;
        double sumNeg = 0;
        for (Double bill : bills) {
            double diff = (int) ((bill - avg) * 100.00) / 100.0;
            if (diff > 0) {
                sumPos += diff;
            } else {
                sumNeg += diff;
            }
        }
        return Math.max(sumPos, -sumNeg);
    }

    private static double getAverage(List<Double> gastos) {
        double suma = 0;
        for (Double gasto : gastos) {
            suma += gasto;
        }
        return suma / gastos.size();
    }
}