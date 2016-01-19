import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Your name: Stefan Kussmaul
 * Class block: H				Date: 1/15/16
 * Lab: 9
 * Title: Cabbages
 * Purpose: Process Strings and files
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File cabbages_file = new File("Cabbages.txt");
        try { // establish file exists up here
            Scanner scan_file = new Scanner(cabbages_file);
            int num_words = firstRead(scan_file);

            scan_file = new Scanner(cabbages_file);
            String[] processed = secondRead(scan_file, num_words);
            System.out.println("\n\nWords sorted alphabetically with duplicates removed--");
            for(int i = 0; i < processed.length; i++) {
                System.out.println(i + " " + processed[i]);
            }

            for(int i = 0; i < 2; i++) {
                System.out.print("\nEnter String to grep: ");
                String to_find = scanner.next();
                scan_file = new Scanner(cabbages_file);
                grep(scan_file, to_find);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: could not open Cabbages.txt");
        }

    }

    private static int firstRead(Scanner readFile) {
        int num_words = 0, longest_length = 0;
        String word, longest_word = "";
        System.out.println("Words found in text --");
        while(readFile.hasNext()) {
            // read in word and strip unwanted punctuation
            word = readFile.next();
            num_words++;
            if (word.length() > longest_length) {
                longest_length = word.length();
                longest_word = word;
            }
            System.out.println(num_words + " " + word);
        }
        System.out.println("The longest word in the text is <" + longest_word + ">");
        return num_words;
    }

    private static String[] secondRead(Scanner readFile, int numWords) {
        String[] words = new String[numWords];
        int word_counter = 0;
        while(readFile.hasNext()) {
            words[word_counter] = stripPunctuation(readFile.next()).toLowerCase();
            word_counter++;
        }
        //String[] processed = removeEmpty(words);
        Arrays.sort(words);
        return removeDuplicates(words);
    }

    // returns new array with all empty elements removed
    private static String[] removeEmpty(String[] words) {
        int new_size = 0;
        for(int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                new_size++;
            }
        }
        String[] result = new String[new_size];
        int words_transferred = 0;
        for(int i = 0; i < words.length; i++) {
            if(!words[i].isEmpty()) {
                result[words_transferred] = words[i];
                words_transferred++;
            }
        }
        return result;
    }

    private static String stripPunctuation(String s) {
        int i = 0;
        while (i < s.length()) {
            if(isPunctuation(s.charAt(i))) {
                s = s.substring(0, i) + s.substring(i + 1);
            } else {
                i++;
            }
        }
        return s;
    }

    private static boolean isPunctuation(char c) {
        // return false if number, lowercase letter, or uppercase letter
        if ((c >= 'a' && c < 'z') || (c >= 'A' && c <= 'Z')) {
            return false;
        } else {
            return true;
        }
    }

    private static String[] removeDuplicates(String[] words) {
        int look_ahead = 1, i = 0;
        while (i < words.length - 1) {
            if (words[i].equals(words[i + look_ahead])) {
                words[i + look_ahead] = "";
                look_ahead++;
            } else {
                i += look_ahead;
                look_ahead = 1;
            }
        }
        return removeEmpty(words);
    }

    private static void grep(Scanner readFile, String toFind) {
        int counter = 0;
        boolean found = false;
        String this_line;
        while(readFile.hasNextLine()) {
            counter++;
            this_line = readFile.nextLine();
            if(this_line.contains(toFind)) {
                int location = this_line.indexOf(toFind);
                System.out.println("Line " + counter + ": " + this_line.substring(0, location) +
                        "<" + toFind + ">" + this_line.substring(location + toFind.length()));
                found = true;
            }
        }
        if(!found) {
            System.out.println("<" + toFind + "> does not appear in the file");
        }
    }
}
