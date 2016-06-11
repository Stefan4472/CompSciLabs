import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Your name: Stefan Kussmaul
 * Class block: H				Date: 5/27/16
 * Lab: Final Project
 * Title: Cryptography
 * Purpose: Demonstrate knowledge of programming
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GridKey current_key = null;
        while (true) {
            System.out.print(
                    "Main Menu:\n" +
                            "1. Import Grid Key from File\n" +
                            "2. Write Current Grid Key to File\n" +
                            "3. Generate Random Grid Key\n" +
                            "4. Encrypt File Using Current Grid Key\n" +
                            "5. Decrypt File Using Current Grid Key\n" +
                            "6. Exit the Program\n" +
                            "Enter Choice: "
            );
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    current_key = importKey();
                    break;
                case 2:
                    if (current_key == null) {
                        System.out.println("There is no current Grid Key to write.\nPlease import one from a file or generate a new one.\n");
                    } else {
                        if (writeKeyToFile(current_key)) {
                            System.out.println("Key written to file successfully\n");
                        } else {
                            System.out.println("There was an error writing the key to the specified file\n");
                        }
                    }
                    break;
                case 3:
                    current_key = new GridKey();
                    System.out.println("Generated Key:\n" + current_key);
                    break;
                case 4:
                    if (current_key == null) {
                        System.out.println("There is no current Grid Key to write.\nPlease import one from a file or generate a new one.\n");
                    } else {
                        encryptFile(current_key);
                    }
                    break;
                case 5:
                    if (current_key == null) {
                        System.out.println("There is no current Grid Key to write.\nPlease import one from a file or generate a new one.\n");
                    } else {
                        decryptFile(current_key);
                    }
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Error: Invalid choice.\n");
                    break;
            }
        }
    }

    private static GridKey importKey() {
        System.out.print("Enter path of file to import Key from: ");
        File to_read = new File(scanner.nextLine());
        try {
            String key = FileIO.readFile(to_read);
            GridKey imported = GridKey.parseGridKey(key);
            System.out.println("\nImported Key:\n" + imported);
            return imported;
        } catch (IOException e) {
            System.out.println("There was an error reading the specified file.\n");
            return null;
        }
    }

    private static boolean writeKeyToFile(GridKey toWrite) {
        System.out.print("Enter path of file to write Key to: ");
        File to_write = new File(scanner.nextLine());
        return FileIO.writeFile(to_write, toWrite.toString());
    }

    private static void encryptFile(GridKey key) {
        System.out.print("Enter path of file to read message from: ");
        File to_read = new File(scanner.nextLine());
        try {
            String message = FileIO.readFile(to_read);
            System.out.println("Original text:\n" + message);
            String encrypted = CipherMachine.encryptMessage(message, key);
            System.out.println("Encrypted text:\n" + encrypted);
            System.out.print("Write encrypted text to file? (y/n) ");
            if (scanner.nextLine().equals("y")) {
                System.out.print("Enter path of file to write to: ");
                File to_write = new File(scanner.nextLine());
                if (FileIO.writeFile(to_write, encrypted)) {
                    System.out.println("Encrypted text written to file successfully\n");
                } else {
                    System.out.println("There was an error writing to the specified file\n");
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error reading the specified file\n");
        }
    }

    private static void decryptFile(GridKey key) {
        System.out.print("Enter path of file to read message from: ");
        File to_read = new File(scanner.nextLine());
        try {
            String message = FileIO.readFile(to_read);
            System.out.println("Original message:\n" + message);
            String decrypted = CipherMachine.decryptMessage(message, key);
            System.out.println("Decrypted text:\n" + decrypted);
            System.out.print("Write decrypted text to file? (y/n) ");
            if (scanner.nextLine().equals("y")) {
                System.out.print("Enter path of file to write to: ");
                File to_write = new File(scanner.nextLine());
                if (FileIO.writeFile(to_write, decrypted)) {
                    System.out.println("Decrypted text written to file successfully\n");
                } else {
                    System.out.println("There was an error writing to the specified file\n");
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error reading the specified file\n");
        }
    }

    private static void exit() {
        System.out.print("Exiting program...");
        System.exit(0);
    }
}
