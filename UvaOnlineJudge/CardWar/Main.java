package UvaOnlineJudge.CardWar;

import java.util.*;

class Main {
    static int NCARDS = 52;
    static int NSUITS = 4;
    static char[] values = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
    static char[] suits = { 'c', 'd', 'h', 's' };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Queue<String>> manos = new ArrayList<Queue<String>>(2);
        while (sc.hasNextLine()) {
            for (int i = 0; i <= 1; i++) {
                String[] line = sc.nextLine().split(" ");
                manos.add(new LinkedList<String>(Arrays.asList(line)));
            }
            war(manos.get(0), manos.get(1));
        }
        sc.close();
        System.exit(0);
    }

    private static int rankCard(char value, char suit) {
        for (int i = 0; i < (Main.NCARDS / Main.NSUITS); i++) {
            if (Main.values[i] == value) {
                for (int j = 0; j < Main.NSUITS; j++) {
                    if (Main.suits[j] == suit) {
                        return i * NSUITS + j;
                    }
                }
            }
        }
        return 0;
    }
    private static void clearQueue(Queue<String> a, Queue<String> b) {
        while (!a.isEmpty())
            b.offer(a.poll());

    }

    private static void war(Queue<String> a, Queue<String> b) {
        int steps = 0;
        boolean inwar = false;
        Queue<String> fieldOfWar = new LinkedList<String>();
        while (!a.isEmpty() && !b.isEmpty() && steps < 1000) {
            steps++;
            String carta1 = a.poll();
            String carta2 = b.poll();
            fieldOfWar.offer(carta1);
            fieldOfWar.offer(carta2);
            if (inwar) {
                inwar = false;
            } else {
                if (rankCard(carta1.charAt(0), carta1.charAt(1)) > rankCard(carta2.charAt(0), carta2.charAt(1))) {
                    clearQueue(fieldOfWar, a);
                } else {

                    if (rankCard(carta1.charAt(0), carta1.charAt(1)) < rankCard(carta2.charAt(0), carta2.charAt(1))) {
                        clearQueue(fieldOfWar, b);
                    } else {

                        if (rankCard(carta1.charAt(0), carta1.charAt(1)) == rankCard(carta2.charAt(0),
                                carta2.charAt(1))) {
                            inwar = true;
                        }
                    }
                }
            }
        }
        if (!a.isEmpty() && b.isEmpty()) {
            System.out.println(String.format("a wins in %d steps \n", steps));
            return;
        }

        if (a.isEmpty() && !b.isEmpty()) {
            System.out.println(String.format("b wins in %d steps \n", steps));
            return;
        }

        if (!a.isEmpty() && !b.isEmpty()) {
            System.out.println(String.format("game tied after %d steps \n", steps));
            return;
        }
        System.out.println(String.format("a and b tie in %d steps \n", steps));
    }
}