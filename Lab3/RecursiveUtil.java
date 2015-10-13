/**
 * Created by lhscompsci on 10/13/15.
 */
public class RecursiveUtil {

    public static void letters(char letter) {
        if(letter == 'a') {
            System.out.print((char) letter);
        } else {
            letters((char) (letter - 1));
            System.out.print(letter);

        }
    }

    public static int twos(int num) {
        if(num % 2 == 0) {
            return twos(num / 2) + 1;
        } else {
            return 0;
        }
    }

    public static boolean powerOf3(int num) {
        if(num == 1) {
            return true;
        } else if(num == 0) {
            return false;
        }
        return powerOf3(num / 3);
    }
    
    public static int reverse(int num) {
        if(num < 10) {
            return num;
        } else {
            return num % 10 * (int) Math.pow(10, pow10(num)) + reverse(num / 10);
        }
    }

    public static int pow10(int num) {
        if(num / 10 == 0) {
            return 0;
        } else {
            return pow10(num / 10) + 1;
        }
    }

    public static void base5(int num) {
        if(num < 5) {
            System.out.print(num);
        } else {
            base5(num / 5);
            System.out.print(num % 5);
        }
    }

    //public static int baseX(int num, int base) {

    //}

    public static void printWithCommas(int num) {
        if(num < 1_000) {
            System.out.print(num);
        } else {
            printWithCommas(num / 1_000);
            System.out.print("," + num % 1_000);
        }
    }
}
