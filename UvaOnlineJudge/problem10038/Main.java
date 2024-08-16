package UvaOnlineJudge.problem10038;

import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            int n = line.length - 2;
            for (int i = 1; i < line.length - 1; i++) {
                int number = Integer.parseInt(line[i]);
                int nextNumber = Integer.parseInt(line[i + 1]);
                int minus = Math.abs(nextNumber - number);
                if (minus == n) {
                    n--;
                    continue;
                }
            }
            if (n == 0) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
        sc.close();
        System.exit(0);
    }
}
