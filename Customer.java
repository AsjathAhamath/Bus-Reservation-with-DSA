import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private int CustomerAge;
    private String CustomerID, CustomerName, CustomerMobileNumber, CustomerEmailId, CustomerAddress, CustomerCity, DOB, Username, Password;

    private static Scanner scanner = new Scanner(System.in);

    public Customer() {

    }

    public Customer(String CustomerID, String CustomerName, String CustomerMobileNumber, String CustomerEmailId,
                    String CustomerAddress, String CustomerCity,String Username,String Password, String DOB, int CustomerAge) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerMobileNumber = CustomerMobileNumber;
        this.CustomerEmailId = CustomerEmailId;
        this.CustomerAddress = CustomerAddress;
        this.CustomerCity = CustomerCity;
        this.DOB = DOB;
        this.CustomerAge = CustomerAge;
        this.Username = Username;
        this.Password = Password;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public int getCustomerAge() {
        return CustomerAge;
    }

    public void setCustomerAge(int customerAge) {
        CustomerAge = customerAge;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return CustomerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        CustomerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmailId() {
        return CustomerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        CustomerEmailId = customerEmailId;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return CustomerCity;
    }

    public void setCustomerCity(String customerCity) {
        CustomerCity = customerCity;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public static void Display(){
        ComClass.println("\n╔══════════════════════════════════════╗");
        ComClass.println("║             Home > Customer          ║");
        ComClass.println("╠══════════════════════════════════════╣");
        ComClass.println("║ 1. Insert Customer                   ║");
        ComClass.println("║ 2. Update Customer                   ║");
        ComClass.println("║ 3. Delete Customer                   ║");
        ComClass.println("║ 4. View All Customers                ║");
        ComClass.println("║ 5. Exit                              ║");
        ComClass.println("╚══════════════════════════════════════╝");
        ComClass.print("Enter your choice: ");
    }
    
    public static void showMenu() {
        Display();
        boolean exit = false;
        while (!exit) {
            

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline left-over
            } catch (InputMismatchException e) {
                ComClass.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // consume the invalid input
                continue; // restart the loop
            }
            
            Customer customer = new Customer();

            switch (choice) {
                case 1:
                    customer.InsertCustomer();
                    break;

                case 2:
                    customer.UpdateCustomer();
                    break;

                case 3:
                    customer.DeleteCustomer();
                    break;

                case 4:
                    ComClass.println("\nHome > Custoemr > All Customers:");
                    ComClass.println("====================================");
                    Customer.viewAllCustomerByInsertionSort();
                    break;

                case 5:
                    exit = true;
                    ComClass.println("Exiting...");
                    break;

                default:
                    ComClass.println("Invalid choice. Please enter a number between 1 to 5");
            }
        }
    }

    public static void Cus_DisplayMenu() {
        ComClass.println("\n╔════════════════════════════════════════╗");
        ComClass.println("║                Main Menu               ║");
        ComClass.println("╠════════════════════════════════════════╣");
        ComClass.println("║ 1. Update your details                 ║");
        ComClass.println("║ 2. View All Buses                      ║");
        ComClass.println("║ 3. Booking                             ║");
        ComClass.println("║ 4. View All Booking                    ║");
        ComClass.println("║ 5. Search Buses by Route and Time      ║");
        ComClass.println("║ 6. Cancelled booking                   ║");
        ComClass.println("║ 7. Promote from Waiting List           ║");
        ComClass.println("║ 8. Logout                              ║");
        ComClass.println("╚════════════════════════════════════════╝");
        ComClass.print("Enter your choice: ");
    }
        
    public static void Cus_Menu(){
        Bus bus = new Bus();
        boolean exit = false;
        while (!exit) {
            Cus_DisplayMenu();
            Customer customer = new Customer();

            int choice = ComClass.getInput(1, 8);  // Adjust range for this menu
            
            switch (choice) {
                case 1:
                    customer.C_UpdateCustomer();
                    break;
                case 2:
                    Bus.viewAllBuses();
                    yesorno();
                    break;
                case 3:
                    Bus.Book_showMenu();
                    break;
                
                case 4:
                    viewCustomerBookings();
                    ComClass.print("________________________________\n");
                    Bus.Can_yesorno();
                    break;
                    
                case 5:
                    ComClass.println("\nHome > Search");
                    ComClass.println("==================");
                    Bus.searchBusesByRouteAndTime();
                    break;

                case 6:
                    bus.Cus_cancelReservation();
                    break;                   
                    
                case 7:
                    bus.promoteFromWaitingList();
                
                case 8:
                    exit = true;
                    ComClass.println("Exiting...");
                    Login.loginApplication();
                    break;
            }
        }
    }

    public static void viewAllBooking() {
        ComClass.println("\nAll Buses:");
        for (Reservation Reservation : DB.Reservation) {
            System.out.println(Reservation);
        }
    }
    
    public static void viewCustomerBookings() {
        Customer customer = Login.getLoggedInCustomer();
        if (customer != null) {
            ComClass.println("\nBookings for Customer ID: " + customer.getCustomerID());
            boolean found = false;
            for (Reservation reservation : DB.Reservation) {
                if (reservation.getCustomerID().equals(customer.getCustomerID())) {
                    System.out.println(reservation);
                    found = true;
                }
            }
            if (!found) {
                ComClass.println("No bookings found for this customer.");
            }
        } else {
            ComClass.println("No customer is currently logged in.");
        }
    }


    public static void yesorno() {
        boolean exit = false;
        while (!exit) {
            ComClass.println("Do you want to Book");
            ComClass.println("1.Yes");
            ComClass.println("2.No");
            ComClass.println("Enter your choice: ");
            int choice = ComClass.getInput(1, 2); // Adjust range for this menu
            switch (choice) {
                case 1:
                    ComClass.print("Enter Bus Number to reserve: ");
                    String busNumberToReserve = scanner.nextLine();
                    Bus busToReserve = Bus.searchBusByNumber(busNumberToReserve);
                    if (busToReserve != null) {
                        busToReserve.Cus_reserveBus();

                    } else {
                        ComClass.println("Bus not found for reservation.");
                    }
                    break;

                case 2:
                    exit = true;
                    ComClass.println("Thank You..!");
                    break;

                default:
                    ComClass.println("Invalid choice. Please enter a number between 1 to 2.");
                    break;
            }
        }
    }

    private static List<Customer> getNewCustomersList() {
        List<Customer> _cusList = new ArrayList<>();
        for (Customer customer : DB.customers) {
            _cusList.add(customer);
        }
        return _cusList;
    }

    public static void viewAllCustomerByInsertionSort() {
        List<Customer> _cusList = getNewCustomersList();
        InsertionSorting.insertionSorting(_cusList);
        for (Customer customer : _cusList) { // Print sorted list
            System.out.println(customer);
        }
    }

    public void InsertCustomer() {
        try {
            ComClass.println("Enter the Customer ID:");
            this.CustomerID = scanner.nextLine();

            ComClass.println("Enter Customer Name:");
            this.CustomerName = scanner.nextLine();

            ComClass.println("Enter the Customer Mobile:");
            this.CustomerMobileNumber = scanner.nextLine();

            ComClass.println("Enter the Customer Email:");
            this.CustomerEmailId = scanner.nextLine();

            ComClass.println("Enter the Customer Address:");
            this.CustomerAddress = scanner.nextLine();

            ComClass.println("Enter the Customer City:");
            this.CustomerCity = scanner.nextLine();

            ComClass.println("Enter the Customer DOB:");
            this.DOB = scanner.nextLine();

            ComClass.println("Enter the Customer Age:");
            this.CustomerAge = Integer.parseInt(scanner.nextLine());

            DB.customers.add(this);
            ComClass.println("Customer inserted successfully");
        } 

        catch (InputMismatchException e) {
            ComClass.println("Invalid input. Please enter a valid number for age.");
            scanner.nextLine(); // consume the invalid input
        } 

        catch (NumberFormatException e) {
            ComClass.println("Invalid input. Please enter a valid number for age.");
        }
    }

    public void Customer__Update() {
        try {
            ComClass.println("Find Customer By ID:");
            String customerID = scanner.nextLine();
            Customer customer = searchCustomerByID(customerID);
            
            if (customer != null) {
                ComClass.println("Enter new Customer Id: ");
                customer.setCustomerID(scanner.nextLine());

                ComClass.println("Enter new Customer Name: ");
                customer.setCustomerName(scanner.nextLine());

                ComClass.println("Enter new Customer Mobile: ");
                customer.setCustomerMobileNumber(scanner.nextLine());

                ComClass.println("Enter new Customer Email: ");
                customer.setCustomerEmailId(scanner.nextLine());

                ComClass.println("Enter new Customer Address: ");
                customer.setCustomerAddress(scanner.nextLine());

                ComClass.println("Enter new Customer City: ");
                customer.setCustomerCity(scanner.nextLine());

                ComClass.println("Enter new Customer DOB: ");
                customer.setDOB(scanner.nextLine());

                ComClass.println("Enter new Customer Age: ");
                customer.setCustomerAge(Integer.parseInt(scanner.nextLine()));

                ComClass.println("Customer updated successfully");
            } 
            else {
                ComClass.println("Customer not found");
            }
        } 
        catch (InputMismatchException e) {
            ComClass.println("Invalid input. Please enter a valid integer for age.");
            scanner.nextLine(); // consume the invalid input
        } 
        catch (NumberFormatException e) {
            ComClass.println("Invalid input. Please enter a valid number for age.");
        }
    }

    public void C_UpdateCustomer() {
        try {
            // Retrieve the logged-in customer
            Customer customer = Login.getLoggedInCustomer();
            
            if (customer != null) {
                // Do not change the Customer ID
                ComClass.println("Updating details for Customer ID: " + customer.getCustomerID());
    
                ComClass.println("Enter new Customer Name: ");
                customer.setCustomerName(scanner.nextLine());
    
                ComClass.println("Enter new Customer Mobile: ");
                customer.setCustomerMobileNumber(scanner.nextLine());
    
                ComClass.println("Enter new Customer Email: ");
                customer.setCustomerEmailId(scanner.nextLine());
    
                ComClass.println("Enter new Customer Address: ");
                customer.setCustomerAddress(scanner.nextLine());
    
                ComClass.println("Enter new Customer City: ");
                customer.setCustomerCity(scanner.nextLine());
    
                ComClass.println("Enter new Customer DOB: ");
                customer.setDOB(scanner.nextLine());
    
                ComClass.println("Enter new Customer Age: ");
                customer.setCustomerAge(Integer.parseInt(scanner.nextLine()));
    
                ComClass.println("Customer updated successfully");
            } else {
                ComClass.println("Customer not found");
            }
        } catch (InputMismatchException e) {
            ComClass.println("Invalid input. Please enter a valid integer for age.");
            scanner.nextLine(); // consume the invalid input
        } catch (NumberFormatException e) {
            ComClass.println("Invalid input. Please enter a valid number for age.");
        }
    }
    
    

    public void UpdateCustomer() {
        try {
            ComClass.println("Find Customer By ID:");
            String customerID = scanner.nextLine();
            Customer customer = searchCustomerByID(customerID);

            if (customer != null) {
                ComClass.println("Enter new Customer Id: ");
                customer.setCustomerID(scanner.nextLine());

                ComClass.println("Enter new Customer Name: ");
                customer.setCustomerName(scanner.nextLine());

                ComClass.println("Enter new Customer Mobile: ");
                customer.setCustomerMobileNumber(scanner.nextLine());

                ComClass.println("Enter new Customer Email: ");
                customer.setCustomerEmailId(scanner.nextLine());

                ComClass.println("Enter new Customer Address: ");
                customer.setCustomerAddress(scanner.nextLine());

                ComClass.println("Enter new Customer City: ");
                customer.setCustomerCity(scanner.nextLine());

                ComClass.println("Enter new Customer DOB: ");
                customer.setDOB(scanner.nextLine());

                ComClass.println("Enter new Customer Age: ");
                customer.setCustomerAge(Integer.parseInt(scanner.nextLine()));

                ComClass.println("Customer updated successfully");
            } 
            else {
                ComClass.println("Customer not found");
            }
        } 
        catch (InputMismatchException e) {
            ComClass.println("Invalid input. Please enter a valid integer for age.");
            scanner.nextLine(); // consume the invalid input
        } 
        catch (NumberFormatException e) {
            ComClass.println("Invalid input. Please enter a valid number for age.");
        }
    }

    public void DeleteCustomer() {
        ComClass.println("Find Customer By ID:");
        String findID = scanner.nextLine();
        Customer customer = searchCustomerByID(findID);

        if (customer != null) {
            DB.customers.remove(customer);
            ComClass.println("Customer deleted successfully");
        } 
        else {
            ComClass.println("Customer not found for delete.");
        }
    }

    public static Customer searchCustomerByID(String customerID) {
        for (Customer customer : DB.customers) {
            if (customer.getCustomerID().equalsIgnoreCase(customerID)) {
                return customer;
            }
        }
        return null;
    }

    public static void ViewAllCustomers() {
        for (Customer customer : DB.customers) {
            Customer.viewAllCustomerByInsertionSort();
            System.out.println(customer);
        }
    }

    public static void Menu() {
        boolean exit = false;
        while (!exit) {
            ApplicationRun.displayMenu();
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
                    ComClass.println("Exiting...");
                    break;
            }
        }
    }


    @Override
    public String toString() {
        return String.format(
            "Customer ID       : %s\n" +
            "Customer Name     : %s\n" +
            "Mobile Number     : %s\n" +
            "Email             : %s\n" +
            "Address           : %s\n" +
            "City              : %s\n" +
            "Date of Birth     : %s\n" +
            "Age               : %d\n",
            CustomerID, CustomerName, CustomerMobileNumber, CustomerEmailId, CustomerAddress, CustomerCity, DOB, CustomerAge
        );
    }
}