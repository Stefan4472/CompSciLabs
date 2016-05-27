/**
 * Created by Stefan on 5/26/2016.
 */
public class StringUtil {

    // returns reversed String
    public static String reverseString(String toReverse) {
        String reversed = "";
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            reversed += toReverse.charAt(i);
        }
        return reversed;
    }

    // turns a 2-d array of characters into a String
    // appends the chars together from left to right, top to bottom of array
    public static String buildString(char[][] charArray) {
        String built = "";
        for (char[] row : charArray) {
            for (char c : row) {
                built += c;
            }
        }
        return built;
    }

    // turns a String into a 2-d array of characters
    // moves from top left to bottom right
    // String must be a single line with 64 characters
    public static char[][] buildCharArray(String string) {
        char[][] array = new char[8][8];
        int row = 0;
        int col = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i != 0 && i % 8 == 0) {
                row++;
                col = 0;
                array[row][col] = string.charAt(i);
                col++;
            } else {
                array[row][col] = string.charAt(i);
                col++;
            }
        }
        return array;
    }

    public static String charArrayToString(char[][] array) {
        String as_string = "";
        for (char[] row : array) {
            for (char c : row) {
                as_string += c;
            }
            as_string += "\n";
        }
        return as_string;
    }
}
