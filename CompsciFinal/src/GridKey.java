import java.io.File;

/**
 * Created by Stefan on 5/26/2016.
 */
public class GridKey {

    private char[][] key;

    public GridKey() {
        key = new char[8][8];
    }

    public GridKey(char[][] key) {
        this.key = key;
    }

    public char[][] getKey() {
        return key;
    }

    // constructs GridKey from String
    // String must contain 8x8
    public static GridKey parseGridKey(String key) throws Exception { // todo: check validity of key
        char[][] parsed = new char[8][8];
        int row = 0, col = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ') {
                parsed[row][col] = ' ';
                col++;
            } else if (key.charAt(i) == 'x' || key.charAt(i) == 'X') {
                parsed[row][col] = 'X';
                col++;
            } else if (key.charAt(i) == '\n') {
                row++;
                col = 0;
            } else {
                throw new Exception("Error: " + key.charAt(i) + " is not a recognized character");
            }
        }
        if (isValid(parsed)) {
            return new GridKey(parsed);
        } else {
            throw new Exception("Error: Invalid GridKey");
        }
    }

    // returns whether key follows rules for proper GridKey
    public static boolean isValid(char[][] key) { // todo
        return true;
    }

    // returns GridKey with characters rotated 90 degrees counter-clockwise
    public static GridKey rotate90Degrees(char[][] toRotate) {
        char[][] original = toRotate;
        char[][] rotated = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rotated[j][7 - i] = original[i][j];
            }
        }
        return new GridKey(rotated);
    }

    @Override
    public String toString() {
        String as_string = "";
        for (char[] row : key) {
            for (char element : row) {
                as_string += element;
            }
            as_string += "\n";
        }
        return as_string;
    }
}
