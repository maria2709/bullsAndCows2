package bullscows;

import com.sun.jdi.IntegerValue;

import java.util.Random;
import java.util.Scanner;

public class Main {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String guess;
        String guessLine;
        int cows = 0;
        int bulls = 0;
        String numberOfDigitsStr;
        int numberOfDigits = 0;
        int numberOfPossible;
        boolean isFinished = false;

        System.out.println("Please, enter the secret code's length:");
        numberOfDigitsStr = sc.nextLine();
        try {
            numberOfDigits = Integer.parseInt(numberOfDigitsStr);
        } catch (RuntimeException e) {
            System.out.println("Error: " + numberOfDigitsStr + " isn't a valid number.");
            System.exit(0);
        }
        if (numberOfDigits == 0) {
            System.out.println("Error. The length cannot be 0");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        numberOfPossible = sc.nextInt();
        if (numberOfPossible > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + numberOfPossible + " because there aren't enough unique digits.");
        } else if (numberOfPossible < numberOfDigits) {
            System.out.println("Error: it's not possible to generate a code with a length of " + numberOfDigits + " with " + numberOfPossible + " symbols.");
            System.exit(0);
        } else {
            System.out.println("Okay, let's start a game!");
            String secretNumber = magicWord(numberOfDigits, numberOfPossible);

            System.out.println("The secret is prepared: " + stars(numberOfDigits));
            System.out.println("The secret is prepared: " + secretNumber);

            int i = 1;
            do {
                System.out.println("Turn " + i + ":");
                guess = sc.next();
                if (secretNumber.equalsIgnoreCase(guess)) {
                    System.out.println("Grade: " + numberOfDigits + " bulls");
                    System.out.println("Congratulations! You guessed the secret code.");
                    isFinished = true;
                } else {
                    bulls = countBulls(secretNumber, guess);
                    cows = countCows(secretNumber, guess);
                    System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)." + "\n");
                }
                i++;
            } while (!isFinished);
        }

    }

    static int countBulls(String magicToString, String guessToString) {
        int bulls = 0;
        for (int i = 0; i < magicToString.length(); i++) {
            if (guessToString.charAt(i) == magicToString.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    static int countCows(String magicToString, String guessToString) {
        int cows1 = 0;
        for (int i = 0; i < magicToString.length(); i++) {      //guess string
            for (int j = 0; j < magicToString.length(); j++) {   // magic string
                if (magicToString.charAt(i) == guessToString.charAt(j)) {
                    cows1++;
                    break;
                }
            }
        }
        return cows1 - countBulls(magicToString, guessToString);
    }

    static String numberToGenerateRandom(int numberOfDigits) {
    //    long pseudoRandomNumber = System.nanoTime();
            long min = 1000000000;
            long max = 2147483641;
            long pseudoRandomNumber = (long) Math.floor(Math.random() *(max - min + 1) + min);
            StringBuilder numberToGenerate = new StringBuilder();
            StringBuilder randomNumerStr = new StringBuilder(String.valueOf(pseudoRandomNumber));
            int i = 1;
            do {
                int n = randomNumerStr.length() - i;
                if (n < 0) {
                    randomNumerStr.insert(0, String.valueOf(System.nanoTime()));
                    n = randomNumerStr.length() - i;

                }
                if (!numberToGenerate.toString().contains(randomNumerStr.substring(n, n + 1))) {
                    numberToGenerate.append(randomNumerStr.charAt(randomNumerStr.length() - i));
                    if (numberToGenerate.charAt(0) == '0') {
                        numberToGenerate.deleteCharAt(0);
                    }
                }
                i++;

            } while (numberToGenerate.length() < numberOfDigits);
            return String.valueOf(numberToGenerate);
    }

    static String magicWord (int numberOfChars, int numberOfPossible) {
        if (numberOfPossible >= 10) {
            String s1 = numberToGenerateRandom(10);
            String s2 = "";
            Random random = new Random();
            String alphbet = "abcdefghijklmnopqrstvuwxyz";
            int numberOfLetters = numberOfPossible - 10;
            s2 = alphbet.substring(0, numberOfLetters);
            System.out.println(s2);
            s2 =  s1 + s2;
            System.out.println(s2);
            StringBuilder shuffled = new StringBuilder();
            StringBuilder initial = new StringBuilder(s2);

            for (int i = 0; i < numberOfPossible; i++) {
                int randomize = random.nextInt(numberOfPossible - i);
                shuffled.append(initial.charAt(randomize));
                initial.deleteCharAt(randomize);
            }
            System.out.println(shuffled.substring(0, numberOfChars));
            return shuffled.substring(0, numberOfChars);

        } else {
            return numberToGenerateRandom(numberOfChars);
        }

    }

    static private String stars (int numberOfDigits){
        String stars = "";
        for (int i = 0; i < numberOfDigits; i++) {
            stars = stars + "*";
        }
        return stars;
    }


}
