/**
 * Your name: Stefan Kussmaul
 * Class block: H				Date: 10/14/15
 * Lab: 3
 * Title: Recursion Lab
 * Purpose: A CLI-based program for testing out recursive functions
 */
public class RecursiveUtil {

    // prints alphabet up to given letter
    public static void letters(char letter) {
        if(letter == 'a') {
            System.out.print((char) letter);
        } else {
            letters((char) (letter - 1));
            System.out.print(letter);

        }
    }

    // returns number of factors of 2 in given integer
    public static int twos(int num) {
        if(num % 2 == 0) {
            return twos(num / 2) + 1;
        } else {
            return 0;
        }
    }

    // returns whether given integer is a power of 3
    public static boolean powerOf3(int num) {
        if(num == 1) {
            return true;
        } else if(num == 0) {
            return false;
        }
        return powerOf3(num / 3);
    }

    // returns integer with digits in reverse order
    public static int reverse(int num) {
        if(Math.abs(num) < 10) {
            return num;
        } else {
            return num % 10 * (int) Math.pow(10, pow10(num)) + reverse(num / 10);
        }
    }

    // returns number of times a number can be divided
    // by 10 before hitting zero
    public static int pow10(int num) {
        if(num / 10 == 0) {
            return 0;
        } else {
            return pow10(num / 10) + 1;
        }
    }

    // converts given base-10 integer in base 5
    public static void base5(int num) {
        if(num < 5) {
            System.out.print(num);
        } else {
            base5(num / 5);
            System.out.print(num % 5);
        }
    }

    // prints given integer with commas
    public static void printWithCommas(int num) {
        if(num < 1_000) {
            System.out.print(num);
        } else {
            printWithCommas(num / 1_000);
            // queries make sure zeroes are not lost
            System.out.print("," + ((num % 1_000 < 100) ? "0" : "") +
                ((num % 1_000 < 10) ? "0" : "") + num % 1_000);
        }
    }
}
