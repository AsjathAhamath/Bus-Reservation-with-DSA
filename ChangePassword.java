/* import java.util.Scanner;

public class ChangePassword {
    private static Scanner scanner = new Scanner(System.in);

    public static void changePassword(Customer customer) {
        if (customer == null) {
            ComClass.println("No customer is currently logged in.");
            return;
        }

        ComClass.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();

        if (!customer.getPassword().equals(currentPassword)) {
            ComClass.println("Current password is incorrect.");
            return;
        }
        
        ComClass.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        ComClass.print("Confirm your new password: ");
        String confirmPassword = scanner.nextLine();

        if (!newPassword.equals(confirmPassword)) {
            ComClass.println("New password and confirmation do not match.");
            return;
        }

        customer.setPassword(newPassword);
        ComClass.println("Password changed successfully.");
    }

    public static void setScanner(Scanner scanner) {
        ChangePassword.scanner = scanner;
    }
}
 */