public class ApplicationRun {

    public static void main(String[] args) {
        DB.data();
        Login.loginApplication();
    }      

    public static void displayMenu() {
        ComClass.println("\n╔════════════════════════════════╗");
        ComClass.println("║          MAIN MENU             ║");
        ComClass.println("╠════════════════════════════════╣");
        ComClass.println("║ 1. Bus Management              ║");
        ComClass.println("║ 2. Customer Management         ║");
        ComClass.println("║ 3. Exit                        ║");
        ComClass.println("╚════════════════════════════════╝");
        ComClass.print("Enter your choice: ");
    }
    
    public static void Menu() {
        boolean exit = false;
        while (!exit) {
            try {
                displayMenu();
                int choice = ComClass.getInput(1, 3);  // Adjust range for this menu
                switch (choice) {
                    case 1:
                        Bus.showMenu();
                        break;
                    case 2:
                        Customer.showMenu();
                        break;
                    case 3:
                        exit = true;
                        ComClass.println("Exiting... Thank you for using the application.");
                        break;
                }
            } catch (Exception e) {
                ComClass.println("An issue occurred while handling your menu choice. Please check the details and try again.");
            }
        }
    }
}
