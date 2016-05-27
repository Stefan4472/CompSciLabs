/**
 * Created by Stefan on 5/26/2016.
 */
public class CipherMachine {

    // uses specified GridKey to encode the message and returns the
    // encoded result
    public static String encodeMessage(String message, GridKey gridKey) {
        String current_line = "";
        String encoded = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '\n') { // linebreak found
                // bring current line up to 64 chars
                while (current_line.length() < 64) {
                    current_line += "^";
                }
                current_line = StringUtil.reverseString(current_line);
                encoded += encodeLine(current_line, gridKey) + "\n";
                current_line = "";
            } else {
                current_line += message.charAt(i);
            }
        }
        return encoded;
    }

    // line must have been processed in the encodeMessage method
    // must be 64 characters and reversed
    private static String encodeLine(String line, GridKey gridKey) {
        char[][] encoded = new char[8][8];
        GridKey key = gridKey;
        for (int i = 1; i <= 4; i++) {
            // take the next 16 characters to encode
            String chunk = line.substring((i - 1) * 16, i * 16);
            int char_counter = 0;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    // found open slot
                    if (key.get(j, k) == ' ') {
                        encoded[j][k] = chunk.charAt(char_counter);
                        char_counter++;
                    }
                }
            }
            key = GridKey.rotate90DegreesCW(key);
        }
        return StringUtil.buildString(encoded);
    }

    // uses given GridKey to decode message and returns decoded message
    public static String decodeMessage(String message, GridKey gridKey) {
        String current_line = "";
        String decoded = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '\n') { // linebreak found
                current_line = decodeLine(current_line, gridKey);
                decoded += current_line + "\n";
                current_line = "";
            } else {
                current_line += message.charAt(i);
            }
        }
        return decoded;
    }

    // line must have been processed in the encodeMessage method
    // must be 64 characters
    private static String decodeLine(String line, GridKey gridKey) {
        // re-build encrypted matrix
        char[][] encrypted = StringUtil.buildCharArray(line);
        String decrypted = "";
        GridKey key = gridKey;
        for (int i = 4; i > 0; i--) {
            key = GridKey.rotate90DegreesCCW(key);
            // read in characters through GridKey from bottom right to top left
            for (int j = 7; j >= 0; j--) {
                for (int k = 7; k >= 0; k--) {
                    // found open slot
                    if (key.get(j, k) == ' ') {
                        decrypted += encrypted[j][k];
                    }
                }
            }
        }
        return decrypted;
    }
}
