package UvaOnlineJudge.problem10315;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] cartas = sc.nextLine().split(" ");
            String[] black = Arrays.copyOfRange(cartas, 0, 5);
            String[] white = Arrays.copyOfRange(cartas, 5, 10);
        }
        sc.close();
        System.exit(0);
    }

    private static double rankMano(String[] mano) {
        
        return 0.0;

    }

}
