import java.io.*;

/**
 * Convenience File reading and writing methods
 */
public class FileIO {

    // reads file and returns String
    public static String readFile(File toRead) throws IOException {
        String line = "";
        String file_text = "";
        FileReader file_reader = new FileReader(toRead);
        BufferedReader buffered_reader = new BufferedReader(file_reader);
        while((line = buffered_reader.readLine()) != null) {
            file_text += line + "\n";
        }
        buffered_reader.close();
        return file_text;
    }

    public static boolean writeFile(File file, String toWrite) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(toWrite);
            bufferedWriter.close();
            return true;
        } catch(IOException e) {
            return false;
        }
    }
}
