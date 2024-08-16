package UvaOnlineJudge.problem10137;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String output = "";
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            List<Double> gastos = new ArrayList<Double>();
            for (int i = 0; i < n; i++) {
                gastos.add(sc.nextDouble());
            }
            double respuesta = solve(gastos);
            String numeroString = String.format("%.16f", respuesta);
            int index = numeroString.indexOf('.');
            String resultado = numeroString.substring(0, index + 3);
            output += String.format("$%s", resultado);
        }
        output = output.replaceAll("\\$", "\n\\$");
        System.out.print(output.substring(1));

        sc.close();

        System.exit(0);
    }

    private static double solve(List<Double> gastos) {
        Collections.sort(gastos);
        double aporte = obtenerAporte(gastos);
        double sumatoria = 0;
        for (int i = 0; i < gastos.size(); i++) {
            if (gastos.get(i) == aporte) {
                continue;
            }
            double diferencia = aporte - gastos.get(i);

            if (diferencia > 0) {
                gastos.set(gastos.size() - 1 - i, gastos.get(gastos.size() - 1 - i) - diferencia);
                sumatoria += diferencia;
            } else {
                break;
            }
        }
        return sumatoria;
    }

    private static double obtenerAporte(List<Double> gastos) {
        double suma = 0;
        for (int i = 0; i < gastos.size(); i++) {
            suma += gastos.get(i);
        }
        return suma / gastos.size();
    }

}
