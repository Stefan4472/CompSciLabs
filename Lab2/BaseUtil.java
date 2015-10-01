import java.util.Arrays;
import java.util.List;

/**
 * Created by lhscompsci on 9/30/15.
 */
public class BaseUtil {

    // look up table for digit to base 10 value and base 10 value to digit
    private static List<Character> values =
            Arrays.asList(new Character[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'});

    // takes a String representing a number in fromBase
    // and returns value in base 10
    public static int toBase10(String num1, int fromBase) { // todo: decimals
        int base10 = 0;
        // move from right to left
        // convert digit to base 10 and multiply by base to the power digit index
        for(int i = num1.length() - 1, j = 0; i >= 0; i--, j++) {
            base10 += lookUpValue(num1.charAt(i)) * pow(fromBase, j);
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
    private static int lookUpValue(char digit) {
        return values.indexOf(digit);
    }

    // look up digit given base 10 value
    private static char getDigit(int value) {
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
