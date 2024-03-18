package flippingbits;

class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        long[] bits = new long[32];
        for (int i = bits.length - 1; i >= 0; i--) {
            if (n == 0) {
                bits[i] = 0;
                continue;
            }
            long remainder = n % 2;
            n = n / 2;
            bits[i] = remainder;
        }
        bits = invertArray(bits);
        long result = 0;
        long exponente = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 1) {
                result += Math.pow(2, exponente);
            }
            exponente++;
        }
        return result;
    }

    private static long[] invertArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
                continue;
            }

            if (array[i] == 1) {
                array[i] = 0;
                continue;
            }
        }
        return array;
    }

}