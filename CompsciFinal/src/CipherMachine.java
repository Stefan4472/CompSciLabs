import java.util.ArrayList;

/**
 * Created by Stefan on 5/26/2016.
 */
public class CipherMachine {

    // uses specified GridKey to encode the message and returns the
    // encoded result
    public static String encodeMessage(String message, GridKey gridKey) {
        ArrayList<String> lines = new ArrayList<>();
        String current_line = "";
        // split message into array of lines (will remove linebreaks
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '\n') { // linebreak found
                // bring current line up to 64 chars
                while (current_line.length() < 64) {
                    current_line += "^";
                }
                current_line = StringUtil.reverseString(current_line);
                lines.add(current_line);
                current_line = "";
            } else {
                current_line += message.charAt(i);
            }
        }
        return "";
    }

    // line must have been processed in the encodeMessage method
    // must be 64 characters and reversed
    private static String encodeLine(String line, GridKey gridKey) {
        char[][] encoded = new char[8][8];
        char[][] key = gridKey.getKey();
        for (int i = 1; i <= 4; i++) {
            // take the next 16 characters to encode
            String chunk = line.substring((i - 1) * 16, i * 16);
            int char_counter = 0;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    // found open slot
                    if (key[j][k] == ' ') {
                        encoded[j][k] = chunk.charAt(char_counter);
                        char_counter++;
                    }
                }
            }
            //key = GridKey.rotate90Degrees(key);
        }
        return "";
    }
}
