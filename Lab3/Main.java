import java.util.Scanner;

/**
 * Your name: Stefan Kussmaul
 * Class block: H				Date: 10/14/15
 * Lab: 3
 * Title: Recursion Lab
 * Purpose: A CLI-based program for testing out recursive functions
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Welcome to Recursion!");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            printMenu();
            handleChoice(scanner.nextInt());

        }
    }

    public static void printMenu() {
        System.out.print(
                "\n\nMenu\n" +
                        "-------------------------\n" +
                        "1. Print Alphabet\n" +
                        "2. Get Number of Factors of Two\n" +
                        "3. Check Power of 3\n" +
                        "4. Reverse Integer\n" +
                        "5. Convert to Base 5\n" +
                        "6. Print with Commas\n" +
                        "7. Quit\n" +
                        "-------------------------\n" +
                        "Enter Option: "
        );
    }

    public static void handleChoice(int menuChoice) {
        Scanner scanner = new Scanner(System.in);
        switch(menuChoice) {
            case 1:
                System.out.print("Enter Letter (a-z): ");
                char letter = scanner.next().charAt(0);
                System.out.print(">> ");
                RecursiveUtil.letters(letter);
                break;
            case 2:
                System.out.print("Enter Integer: ");
                int param = scanner.nextInt();
                System.out.print(">> ");
                System.out.print(RecursiveUtil.twos(param));
                break;
            case 3:
                System.out.print("Enter Positive Integer: ");
                param = scanner.nextInt();
                System.out.print(">>" );
                System.out.print(param + (RecursiveUtil.powerOf3(param) ? " is " : " is not ") + " a power of 3");
                break;
            case 4:
                System.out.print("Enter Integer to Reverse: ");
                param = scanner.nextInt();
                System.out.print(">> ");
                System.out.print(RecursiveUtil.reverse(param));
                break;
            case 5:
                System.out.print("Enter Integer to Convert to Base 5: ");
                param = scanner.nextInt();
                System.out.print(">> ");
                RecursiveUtil.base5(param);
                break;
            case 6:
                System.out.print("Enter Number to Format: ");
                param = scanner.nextInt();
                System.out.print(">> ");
                RecursiveUtil.printWithCommas(param);
                break;
            case 7:
                System.out.print("Exiting Program...");
                System.exit(0);
        }
    }
}
