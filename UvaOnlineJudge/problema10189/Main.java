package problema10189;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            int fields = 1;
            while (sc.hasNext()) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                if (n == 0 && m == 0) {
                    break;
                }
                String[][] campo = new String[n][m];
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    campo[i] = sc.nextLine().split("");
                }
                String[][] campoDescubierto = solve(cambiarPuntoPorCeros(campo));
                imprimirCampoDescubierto(campoDescubierto, fields);
                fields++;
            }
            sc.close();

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.exit(0);
        }
    }

    private static String[][] cambiarPuntoPorCeros(String[][] campo) {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                String a = campo[i][j];
                if (a.equals(".")) {
                    campo[i][j] = "0";
                }
            }
        }
        return campo;
    }

    private static void imprimirCampoDescubierto(String[][] campo, int field) {
        if (field > 1) {
            System.out.println("");
        }
        System.out.println(String.format("Field #%d:", field));
        for (String[] fila : campo) {
            for (String casilla : fila) {
                System.out.print(casilla);
            }
            System.out.println("");
        }
    }

    private static String[][] solve(String[][] campo) {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                if (!campo[i][j].equals("*")) {
                    continue;
                }
                if (isInRange(campo, i + 1, j)) {
                    campo[i + 1][j] = String.valueOf(Integer.valueOf(campo[i + 1][j]) + 1);
                }
                if (isInRange(campo, i - 1, j)) {
                    campo[i - 1][j] = String.valueOf(Integer.valueOf(campo[i - 1][j]) + 1);
                }

                if (isInRange(campo, i, j + 1)) {
                    campo[i][j + 1] = String.valueOf(Integer.valueOf(campo[i][j + 1]) + 1);
                }

                if (isInRange(campo, i, j - 1)) {
                    campo[i][j - 1] = String.valueOf(Integer.valueOf(campo[i][j - 1]) + 1);
                }

                if (isInRange(campo, i - 1, j - 1)) {
                    campo[i - 1][j - 1] = String.valueOf(Integer.valueOf(campo[i - 1][j - 1]) +
                            1);
                }

                if (isInRange(campo, i + 1, j + 1)) {
                    campo[i + 1][j + 1] = String.valueOf(Integer.valueOf(campo[i + 1][j + 1]) +
                            1);
                }

                if (isInRange(campo, i - 1, j + 1)) {
                    campo[i - 1][j + 1] = String.valueOf(Integer.valueOf(campo[i - 1][j + 1]) +
                            1);
                }

                if (isInRange(campo, i + 1, j - 1)) {
                    campo[i + 1][j - 1] = String.valueOf(Integer.valueOf(campo[i + 1][j - 1]) +
                            1);
                }
            }
        }
        return campo;
    }

    private static boolean isInRange(String[][] campo, int i, int j) {
        return i >= 0 &&
                j >= 0 &&
                i < campo.length &&
                j < campo[i].length &&
                !campo[i][j].equals("*");

    }
}
