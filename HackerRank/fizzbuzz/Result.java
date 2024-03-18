class Result {

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            boolean multiploDeCinco = i % 5 == 0;
            boolean multiploDe3 = i % 3 == 0;
            if (multiploDeCinco && multiploDe3) {
                System.out.println("FizzBuzz");
                continue;
            }

            if (multiploDe3 && !multiploDeCinco) {
                System.out.println("Fizz");
                continue;
            }
            if (multiploDeCinco && !multiploDe3) {
                System.out.println("Buzz");
                continue;
            }

            if (!multiploDeCinco && !multiploDe3) {
                System.out.println(i);
                continue;
            }
        }
    }
}
