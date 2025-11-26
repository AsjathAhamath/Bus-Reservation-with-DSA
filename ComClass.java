import java.util.InputMismatchException;
import java.util.Scanner;

public class ComClass {
    private static Scanner scanner = new Scanner(System.in);

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static int getInput(int min, int max) {
        int input = -1;
        while (true) {
            try {
                ComClass.print("Enter a number between " + min + " and " + max + ": ");
                input = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (input >= min && input <= max) {
                    return input;
                } else {
                    ComClass.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                ComClass.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
            ComClass.println("_____________________________________________");
            ComClass.println("Re-enter the correct number: ");
        }
    }
}
