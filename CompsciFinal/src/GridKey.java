import java.util.Random;

/**
 * Your name: Stefan Kussmaul
 * Class block: H				Date: 5/27/16
 * Lab: Final Project
 * Title: Cryptography
 * Purpose: Demonstrate knowledge of programming
 */
public class GridKey {

    private char[][] key;

    // creates a new GridKey and generates a new key
    public GridKey() {
        key = new char[8][8];
        ArrayUtil.fillArray(key, 'X');
        Random random = new Random();
        for (int i = 1; i <= 16; i++) {
            // randomly choose next quadrant to put in a blank space
            int quadrant = random.nextInt(4);
            // figure out where number would be in first quadrant
            int row = (i - 1) / 4;
            int col = (i - 1) % 4;
            // determine coordinates where number will land given quadrant
            switch (quadrant) {
                case 0:
                    key[row][col] = ' ';
                    break;
                case 1:
                    key[col][7 - row] = ' ';
                    break;
                case 2:
                    key[7 - row][7 - col] = ' ';
                    break;
                case 3:
                    key[7 - col][row] = ' ';
                    break;
            }
        }
    }

    public GridKey(char[][] key) {
        this.key = key;
    }

    public char[][] getKey() {
        return key;
    }

    // returns char at (row, col) of key
    public char get(int row, int col) {
        return key[row][col];
    }

    // constructs GridKey from String
    // String must contain 8x8
    public static GridKey parseGridKey(String key) { // todo: check validity of key
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
                //throw new Exception("Error: " + key.charAt(i) + " is not a recognized character");
                return null;
            }
        }
        if (isValid(parsed)) {
            return new GridKey(parsed);
        } else {
            //throw new Exception("Error: Invalid GridKey");
            return null;
        }
    }

    // returns whether key follows rules for proper GridKey
    public static boolean isValid(char[][] key) { // todo
        return true;
    }

    // returns GridKey with characters rotated 90 degrees clockwise
    public static GridKey rotate90DegreesCW(GridKey toRotate) {
        char[][] original = toRotate.getKey();
        char[][] rotated = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rotated[j][7 - i] = original[i][j];
            }
        }
        return new GridKey(rotated);
    }

    // returns GridKey with characters rotated 90 degrees counter-clockwise
    public static GridKey rotate90DegreesCCW(GridKey toRotate) {
        char[][] original = toRotate.getKey();
        char[][] rotated = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rotated[7 - j][i] = original[i][j];
            }
        }
        return new GridKey(rotated);
    }

    @Override // return key as String
    public String toString() {
        return StringUtil.charArrayToString(key);
    }
}
