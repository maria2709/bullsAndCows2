
class BigIntegerConverter {

    /**
     * @param number string representing the number
     * @return BigInteger instance
     */
    public static java.math.BigInteger getBigInteger(String number) {
        java.math.BigInteger result = new java.math.BigInteger(number);
        return result;
    }

    public static void main(String[] args) {
        int multi = 200;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String initial = scan.nextLine();
        System.out.println(initial + " multiplied by 200 is " +
                BigIntegerConverter.getBigInteger(initial).multiply(java.math.BigInteger.valueOf(multi)));

        int a = 0;
        int b = 5;
        int d = a < 0 && b > 0 ? 1 : -1;
        System.out.println(d);
    }
}