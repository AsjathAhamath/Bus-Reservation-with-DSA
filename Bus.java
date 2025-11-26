import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bus extends CrudOperations<Bus> {
    private String BusID;
    private String busNumber;
    private int totalSeats;
    private String startingPoint;
    private String endingPoint;
    private LocalTime startingTime;
    private double fare;
    private List<Reservation> reservations;
    private Queue waitingList;

    private static Scanner scanner = new Scanner(System.in);

    public Bus() {
        this.reservations = new ArrayList<>();
        this.waitingList = new Queue();
    }

    public Bus(String busID, String busNumber, int totalSeats, String startingPoint, String endingPoint, LocalTime startingTime, double fare) {
        this.BusID = busID;
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.reservations = new ArrayList<>();
        this.waitingList = new Queue();
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String bUSID) {
        BusID = bUSID;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Queue getWaitingList() {
        return waitingList;
    }
    
    public static void Display(){
        ComClass.println("\n╔════════════════════════════════════════════════════╗");
        ComClass.println("║                Home > Bus Management               ║");
        ComClass.println("╠════════════════════════════════════════════════════╣");
        ComClass.println("║ 1. Insert Bus                                      ║");
        ComClass.println("║ 2. Update Bus                                      ║");
        ComClass.println("║ 3. Delete Bus                                      ║");
        ComClass.println("║ 4. Reserve Bus                                     ║");
        ComClass.println("║ 5. View All Buses                                  ║");
        ComClass.println("║ 6. View All Reservation                            ║");
        ComClass.println("║ 7. Search Buses by Route and Time                  ║");
        ComClass.println("║ 8. Reserve Bus                                     ║");
        ComClass.println("║ 9. Cancel Reservation                              ║");
        ComClass.println("║ 10. Promote from Waiting List                      ║");
        ComClass.println("║ 11. Exit                                           ║");
        ComClass.println("╚════════════════════════════════════════════════════╝");
        ComClass.print("Enter your choice: ");
    }

    public static void Book_showMenu(){
        ComClass.println("\nHome > Booking");
        ComClass.println("==================");
        ComClass.print("Enter Bus Number to reserve: ");
        String busNumberToReserve = scanner.nextLine();
        Bus busToReserve = searchBusByNumber(busNumberToReserve);
        if (busToReserve != null) {
            busToReserve.Cus_reserveBus();
            } else {
            ComClass.println("Bus not found for reservation.");
            }            
    }
    
    public static void AD_Book_showMenu(){
        ComClass.println("\nHome > Booking");
        ComClass.println("==================");
        ComClass.print("Enter Bus Number to reserve: ");
        String busNumberToReserve = scanner.nextLine();
        Bus busToReserve = searchBusByNumber(busNumberToReserve);
        if (busToReserve != null) {
            busToReserve.reserveBus();
            } else {
            ComClass.println("Bus not found for reservation.");
            }            
    }

    public static void showMenu() {
        Bus bus = new Bus();
        boolean exit = false;
        while (!exit) {
            try {
                Display();
                int choice = ComClass.getInput(1, 11); // Using getInput() handles input validation
    
                switch (choice) {
                    case 1:
                        bus.create(new Bus()); // Create a new Bus instance
                        break;
                    case 2:
                        Bus updateBus = new Bus(); // Create an instance for updating
                        ComClass.print("Enter Bus Number to update: ");
                        String busNumber = scanner.nextLine();
                        updateBus = bus.read(busNumber);
                        if (updateBus != null) {
                            bus.update(updateBus);
                        } else {
                            ComClass.println("Bus not found.");
                        }
                        break;
                    case 3:
                        ComClass.print("Enter Bus Number to delete: ");
                        String busNumberToDelete = scanner.nextLine();
                        bus.delete(busNumberToDelete);
                        break;
                    // Other cases
                    case 4:
                        Bus.AD_Book_showMenu();
                        break;
                        
                    case 5:
                        Bus.viewAllBuses();
                        break;

                    case 6:
                        Customer.viewAllBooking();
                    case 7:
                        Bus.searchBusesByRouteAndTime();
                        break;
                    case 8:
                        ComClass.print("Enter Bus Number to reserve: ");
                        String busNumberToReserve = scanner.nextLine();
                        Bus busToReserve = searchBusByNumber(busNumberToReserve);
                        if (busToReserve != null) {
                            busToReserve.reserveBus();
                        } else {
                            ComClass.println("Bus not found for reservation.");
                        }
                        break;
                    case 9:
                        ComClass.println("Cancel Reservation:");
                        bus.Cus_cancelReservation();
                        break;
                    case 10:
                        ComClass.println("Promote from Waiting List:");
                        bus.promoteFromWaitingList();
                        break;
                    case 11:
                        exit = true;
                        ComClass.println("Exiting...");
                        break;
                    default:
                        // No action needed since ComClass.getInput() already handles invalid choices
                        break;
                }
            } catch (Exception e) {
                ComClass.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    @Override
    public void create(Bus bus) {
        try {
            System.out.print("Enter Bus ID: ");
            bus.BusID = scanner.nextLine();

            System.out.print("Enter Bus Number: ");
            bus.busNumber = scanner.nextLine();

            System.out.print("Enter Total Seats: ");
            bus.totalSeats = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Starting Point: ");
            bus.startingPoint = scanner.nextLine();

            System.out.print("Enter Ending Point: ");
            bus.endingPoint = scanner.nextLine();

            System.out.print("Enter Starting Time (HH:mm): ");
            String startTimeStr = scanner.nextLine();
            bus.startingTime = LocalTime.parse(startTimeStr);

            System.out.print("Enter Fare: ");
            bus.fare = Double.parseDouble(scanner.nextLine());
            DB.Buses.add(bus);
            ComClass.println("Bus inserted successfully");
        } catch (NumberFormatException e) {
            ComClass.println("Invalid number format. Please enter a valid number.");
        } catch (DateTimeParseException e) {
            ComClass.println("Invalid time format. Please enter time in HH:mm format.");
        }
    }
    
    @Override
    public Bus read(String busNumber) {
        for (Bus bus : DB.Buses) {
            if (bus.getBusNumber().equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }


    @Override
    public void update(Bus updatedBus) {
        try {
            Bus bus = read(updatedBus.getBusNumber());

            if (bus != null) {
                bus.setBusNumber(updatedBus.getBusNumber());
                bus.setTotalSeats(updatedBus.getTotalSeats());
                bus.setStartingPoint(updatedBus.getStartingPoint());
                bus.setEndingPoint(updatedBus.getEndingPoint());
                bus.setStartingTime(updatedBus.getStartingTime());
                bus.setFare(updatedBus.getFare());
                ComClass.println("Bus updated successfully");
            } else {
                ComClass.println("Bus not found.");
            }
        } catch (NumberFormatException e) {
            ComClass.println("Invalid number format. Please enter a valid number.");
        } catch (DateTimeParseException e) {
            ComClass.println("Invalid time format. Please enter time in HH:mm format.");
        }
    }

    @Override
    public void delete(String busNumber) {
        Bus bus = read(busNumber);

        if (bus != null) {
            DB.Buses.remove(bus);
            ComClass.println("Bus deleted successfully");
        } else {
            ComClass.println("Bus not found.");
        }
    }

    public void Cus_reserveBus() {

        Customer customer = Login.getLoggedInCustomer();
        
        ComClass.println("Enter Customer ID: "+ customer.getCustomerID());

        ComClass.println("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        ComClass.println("Enter Bus Number: ");
        String BusNumber = scanner.nextLine();

        ComClass.println("Enter Seat Number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        LocalDateTime now = LocalDateTime.now();
        Reservation reservation = new Reservation(customer.getCustomerID(),customerName,BusNumber, now, seatNumber);

        if (reservations.size() < totalSeats ) {
            reservations.add(reservation);
            ComClass.println("Seat " + seatNumber + " reserved successfully for " + customer.getCustomerID());
            ComClass.println("_____________________________________________________");
        } else {
            waitingList.enqueue(reservation);
            ComClass.println("Bus is full. Added " + customer.getCustomerID() + " to the waiting list for seat " + seatNumber);
            ComClass.println("______________________________________________________");
        }
    }

    public static Bus searchBusByNumber(String busNumber) {
        for (Bus bus : DB.Buses) {
            if (bus.getBusNumber().equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    
    public static List<Bus> searchBusesByRouteAndTime() {
        ComClass.print("Enter Starting Point: ");
        String startingPoint = scanner.nextLine();

        ComClass.print("Enter Ending Point: ");
        String endingPoint = scanner.nextLine();

        ComClass.print("Enter Starting Time (HH:mm): ");
        String startTimeStr = scanner.nextLine();

        LocalTime startingTime = LocalTime.parse(startTimeStr);
        List<Bus> foundBuses = new ArrayList<>();

        for (Bus bus : DB.Buses) {
            if (bus.getStartingPoint().equalsIgnoreCase(startingPoint) &&
                    bus.getEndingPoint().equalsIgnoreCase(endingPoint) &&
                    bus.getStartingTime().equals(startingTime)) {
                foundBuses.add(bus);
            }
        }

        if (foundBuses.isEmpty()) {
            ComClass.println("\nBuses not found for route " + startingPoint + " to " + endingPoint + " at " + startTimeStr);
        } else {
            ComClass.println("\nBuses found for route " + startingPoint + " to " + endingPoint + " at " + startTimeStr + ":");
            for (Bus bus : foundBuses) {
                System.out.println(bus);
            }
        }

        return foundBuses;
    }

    public static void viewAllBuses() {
        ComClass.println("\nAll Buses:");
        for (Bus bus : DB.Buses) {
            System.out.println(bus);
        }
    }

    public static void Can_yesorno(){
        boolean exit = false;
        Bus bus = new Bus();
        while (!exit) {
            ComClass.println("Do you want to Cancelled");
            ComClass.println("1.Yes");
            ComClass.println("2.No");
            ComClass.println("Enter your choice: ");
            int choice = ComClass.getInput(1, 2); // Adjust range for this menu
            switch (choice) {
                case 1:
                    bus.Cus_cancelReservation();
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

    public void AD_cancelReservation() {
        boolean found = false;

        ComClass.println("Enter Customer Name to cancel reservation: ");
        String customerName = scanner.nextLine().trim();

        ComClass.println("Enter Bus Number to cancel reservation: ");
        String busNumber = scanner.nextLine().trim();

        // First, find the reservation to cancel
        Reservation reservationToCancel = null;
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerName().equalsIgnoreCase(customerName) && reservation.getBusNumber().equalsIgnoreCase(busNumber)) {
                reservationToCancel = reservation;
                break;
            }
        }

        if (reservationToCancel != null) {

            reservations.remove(reservationToCancel);
            
            DB.Reservation.remove(reservationToCancel);

            ComClass.println("Reservation cancelled for " + customerName + " on Bus Number " + busNumber);
            found = true;

            // Check waiting list
            notifyWaitingList();
        }

        if (!found) {
            ComClass.println("Reservation not found for " + customerName + " on Bus Number " + busNumber);
        }
    }

    public void reserveBus(){                       
        
        ComClass.print("Enter Customer ID: ");
        String customerID = scanner.nextLine();

        ComClass.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        ComClass.print("Confirm Bus Number: ");
        String BusNumber = scanner.nextLine();
        

        ComClass.print("Enter Seat Number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        
        LocalDateTime now = LocalDateTime.now();

        Reservation reservation = new Reservation(customerID,customerName,BusNumber, now, seatNumber);

        if (reservations.size() < totalSeats) {
            reservations.add(reservation);
            ComClass.println("Seat " + seatNumber + " reserved successfully for " + customerID);
            ComClass.println("___________________________");
        }

        else {
            waitingList.enqueue(reservation);
            ComClass.println("Bus is full. Added " + customerID + " to the waiting list for seat " + seatNumber);
            ComClass.println("___________________________");
        }
    }

    
    public void Cus_cancelReservation() {
        ComClass.print("Enter Customer Name to cancel reservation: ");
        String customerName = scanner.nextLine().trim();
    
        ComClass.print("Enter Bus Number to cancel reservation: ");
        String busNumber = scanner.nextLine().trim();
    
        Bus bus = searchBusByNumber(busNumber);
        if (bus != null) {
            Reservation reservationToCancel = null;
            for (Reservation reservation : bus.getReservations()) {
                if (reservation.getCustomerName().equalsIgnoreCase(customerName) &&
                    reservation.getBusNumber().equalsIgnoreCase(busNumber)) {
                    reservationToCancel = reservation;
                    break;
                }
            }
    
            if (reservationToCancel != null) {
                bus.getReservations().remove(reservationToCancel);
                ComClass.println("Reservation cancelled successfully for " + customerName + " on Bus Number " + busNumber);
                notifyWaitingList();

            } else {
                ComClass.println("Reservation not found for " + customerName + " on Bus Number " + busNumber);
            }
        } else {
            ComClass.println("Bus not found.");
        }
    }
    
    private void notifyWaitingList() {
        if (!waitingList.isEmpty()) {
            List<Reservation> notifiedEntries = new ArrayList<>();
            QNode current = waitingList.getFront();

            while (current != null) {
                Reservation waitingEntry = current.reservation;
                int requestedSeat = waitingEntry.getSeatNumber();
                boolean seatAvailable = reservations.stream().noneMatch(reservation -> reservation.getSeatNumber() == requestedSeat);
                
                if (seatAvailable) {
                    reservations.add(waitingEntry);
                    notifiedEntries.add(waitingEntry);
                    ComClass.println("Notified " + waitingEntry.getCustomerName() + " from waiting list for seat " + requestedSeat);
                    current = current.next;
                    waitingList.dequeue(); // Remove from waiting list
                } else {
                    current = current.next;
                }
            }
        }
    }

    public void promoteFromWaitingList() {
        if (!waitingList.isEmpty()) {
            Reservation nextReservation = waitingList.dequeue();
            reservations.add(nextReservation);
            ComClass.println("Promoted " + nextReservation.getCustomerName() + " from waiting list");
            notifyCustomer(nextReservation);
        } else {
            System.out.println("No one in the waiting list to promote.");
        }
    }

    private void notifyCustomer(Reservation customer) {
        // Logic to notify the customer
        ComClass.println("Notification sent to customer " + customer.getCustomerName() + " (ID: "
                + customer.getCustomerID() + ") for reservation.");
    }

    @Override
    public String toString() {
        return String.format(
            "Bus ID   : %s\n" +
            "Bus Number   : %s\n" +
            "Total Seats  : %d\n" +
            "Starting Point: %s\n" +
            "Ending Point  : %s\n" +
            "Starting Time : %s\n" +
            "Fare          : %.2f\n",
            BusID,busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare
        );
    }
}