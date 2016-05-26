import java.io.File;
import java.io.IOException;

/**
 * Created by Stefan on 5/26/2016.
 */
public class Main {

    public static void main(String[] args) {
        try {
            String grid_key = FileIO.readFile(new File("grid1"));
            String message = FileIO.readFile(new File("message"));
            GridKey parsed = GridKey.parseGridKey(grid_key);
            FileIO.writeFile(new File("encoded"), CipherMachine.encodeMessage(message, parsed));
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
