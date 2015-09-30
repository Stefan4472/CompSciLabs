import java.util.Arrays;
import java.util.List;

/**
 * Created by lhscompsci on 9/30/15.
 */
public class BaseUtil {

    // look up table where index of char is value of char
    private static List<Character> values =
            Arrays.asList(new Character[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'});

    // takes a String representing a number in fromBase
    // and returns in base 10
    public static int toBase10(String num1, int fromBase) {
        int base10 = 0;
        for(int i = num1.length() - 1, j = 0; i >= 0; i--, j++) {
            base10 += lookUpValue(num1.charAt(i)) * pow(fromBase, j);
        }
        return base10;
    }

    // converts number from base 10 into specified base
    public static String fromBase10(int base10, int newBase) {
        String result = "";
        do {
            int remainder = base10 % newBase;
            base10 /= newBase;
            result = getDigit(remainder) + result;
        } while(base10 > 0);
        return result;
    }

    // looks up value of digit
    private static int lookUpValue(char digit) {
        return values.indexOf(digit);
    }

    // returns digit given value
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
