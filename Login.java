import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static String username;
    private static String password;
    private static Customer loggedInCustomer;

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Login.scanner = scanner;
    }

    public static void loginApplication() {
        ComClass.println("\n╔═══════════════════════════╗");
        ComClass.println("║         Are you:          ║");
        ComClass.println("╠═══════════════════════════╣");
        ComClass.println("║ 1. Admin                  ║");
        ComClass.println("║ 2. Customer               ║");
        ComClass.println("╚═══════════════════════════╝");
        ComClass.print("Enter your choice: ");

        try {
            int choice = ComClass.getInput(1, 2);
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    signupOrLogin();
                    break;
            }
        } catch (Exception e) {
            ComClass.println("An error occurred while processing your choice. Please try again.");
            scanner.nextLine(); // Clear the buffer
            loginApplication(); // Restart login process
        }
    }

    public static void signupOrLogin() {
        try {
            ComClass.println("+=======================================+");
            ComClass.println(" | Welcome to the Bus Reservation System |");
            ComClass.println("+=======================================+");
            ComClass.println("Please choose an option:");
            ComClass.println("1. Login");
            ComClass.println("2. Sign Up");
            ComClass.println("3. Exit");
            ComClass.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    customerLogin();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    ComClass.println("Exiting...");
                    return;
                default:
                    ComClass.println("Invalid choice. Please enter 1, 2, or 3.");
                    signupOrLogin(); // Recursive call to handle invalid input
                    break;
            }
        } catch (Exception e) {
            ComClass.println("Invalid input. Please enter a valid number (1, 2, or 3).");
            scanner.nextLine(); // Clear buffer
            signupOrLogin(); // Recursive call to handle input error
        }
    }

    public static void register() {
        try {
            Customer customer = new Customer();
            customer.InsertCustomer();
        } catch (Exception e) {
            ComClass.println("An error occurred while registering the customer. Please try again.");
            e.printStackTrace(); // Print stack trace for debugging purposes
        }
    }

    private static void adminLogin() {
        try {
            String adminUsername = "Asjath";
            String adminPassword = "A1234";

            ComClass.println("Enter your Username:");
            username = scanner.nextLine();

            ComClass.println("Enter your Password:");
            password = scanner.nextLine();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                ComClass.println("Welcome! Have a good day.");
                ApplicationRun.Menu(); // Assuming menu() exists in Customer

            } else if (username.equals(adminUsername)) {
                ComClass.println("Invalid Password.");
                loginApplication(); // Restart login process

            } else if (password.equals(adminPassword)) {
                ComClass.println("Invalid Username.");
                loginApplication(); // Restart login process

            } else {
                ComClass.println("Invalid Username and Password. Please check your credentials.");
                loginApplication(); // Restart login process
            }

        } catch (Exception e) {
            ComClass.println("There was an unforeseen mistake. Please give it another go later.");
            scanner.nextLine(); // Clear input buffer
            loginApplication(); // Restart login process
        }
    }

    private static void customerLogin() {
        try {
            ComClass.println("\n=== Customer Login ===");

            ComClass.print("Enter your Username: ");
            username = scanner.nextLine();

            ComClass.print("Enter your Password: ");
            password = scanner.nextLine();

            boolean isLoggedIn = false;
            for (Customer customer : DB.customers) {
                if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                    ComClass.println("\n╔══════════════════════════════════╗");
                    ComClass.println("║       Welcome, Customer!         ║");
                    ComClass.println("╚══════════════════════════════════╝");
                    loggedInCustomer = customer; // Store the logged-in customer
                    Customer.Cus_Menu(); // Assuming cusMenu() exists in Customer
                    isLoggedIn = true;
                    break;
                }
            }

            if (!isLoggedIn) {
                ComClass.println("\n╔══════════════════════════════════╗");
                ComClass.println("║ Invalid Username or Password.    ║");
                ComClass.println("║ Please check your credentials.   ║");
                ComClass.println("╚══════════════════════════════════╝");
                loginApplication(); // Restart login process
            }

        } catch (Exception e) {
            ComClass.println("\n╔══════════════════════════════════╗");
            ComClass.println("║ There was an unforeseen mistake.  ║");
            ComClass.println("║ Please try again later.           ║");
            ComClass.println("╚══════════════════════════════════╝");
            scanner.nextLine(); // Clear input buffer
            loginApplication(); // Restart login process
        }
    }

    public static Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }
}
