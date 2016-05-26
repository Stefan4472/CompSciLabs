import java.io.File;
import java.io.IOException;

/**
 * Created by Stefan on 5/26/2016.
 */
public class Main {

    public static void main(String[] args) {
        try {
            String grid_key = FileIO.readFile(new File("grid1"));
            System.out.println("File contents:\n" + grid_key);
            GridKey parsed = GridKey.parseGridKey(grid_key);
            System.out.println(parsed.toString());
            System.out.println("\nRotated 90 degrees:\n" + GridKey.rotate90Degrees(parsed.getKey()));
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
