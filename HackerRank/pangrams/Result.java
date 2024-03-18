package pangrams;

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        String sLowerCase = s.toLowerCase();
        char[] alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        int count = 0;
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < sLowerCase.length(); j++) {
                char a = sLowerCase.charAt(j);
                char b = alphabet[i];
                if (a == b) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        if (count == alphabet.length) {
            return "pangram";
        } else {
            return "not pangram";
        }
        // Write your code here

    }

}