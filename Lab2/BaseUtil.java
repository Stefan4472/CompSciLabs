import java.util.Arrays;
import java.util.List;

/**
 * Your name: Stefan Kussmaul
 * Class block: H				Date: 10/6/15
 * Lab: 2
 * Title: Middle Earth Based Math
 * Purpose: A CLI-based program for executing various mathematical functions
 * on numbers in different bases.
 */
public class BaseUtil {

    // look up table for digit to base 10 value and base 10 value to digit
    private static List<Character> values =
            Arrays.asList(new Character[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'});

    // takes a String representing a number in fromBase
    // and returns value in base 10
    public static int toBase10(String num1, int fromBase) throws NumberFormatException { // todo: decimals
        int base10 = 0;
        boolean decimal_point = false;
        // move from right to left
        // convert digit to base 10 and multiply by base to the power digit index
        for(int i = num1.length() - 1, j = 0; i >= 0; i--, j++) {
            if(num1.charAt(i) == '.') {
                decimal_point = true;
            } else if(lookUpValue(num1.charAt(i)) >= fromBase) { // check base makes sense
                throw new NumberFormatException("Number does not match base");
            } else {
                base10 += lookUpValue(num1.charAt(i)) * pow(fromBase, j);
            }
        }
        return base10;
    }

    // converts number from base 10 into specified base
    public static String fromBase10(int base10, int newBase) {
        String result = "";
        do { // use remainder method
            int remainder = base10 % newBase;
            base10 /= newBase;
            result = getDigit(remainder) + result;
        } while(base10 > 0);
        return result;
    }

    // look up base 10 value given digit
    public static int lookUpValue(char digit) {
        return values.indexOf(digit);
    }

    // look up digit given base 10 value
    public static char getDigit(int value) {
        return values.get(value);
    }

    // returns base raised to the power exponent
    public static double pow(double base, int exponent) {
        double result = 1;
        for(int i = 0; i < abs(exponent); i++) {
            result *= base;
        }
        return exponent < 0 ? 1.0 / result : result;
    }

    // returns absolute value of number
    public static double abs(double num) {
        return num < 0 ? -num : num;
    }
}
