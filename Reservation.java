import java.time.LocalDateTime;
// import java.time.LocalTime;

public class Reservation{
    private String CustomerID,customerName,BusNumber;
    private LocalDateTime reservationTime;
    private int seatNumber;
    
    
    public Reservation(String CustoemrID,String CustomerName,String BusNumber,LocalDateTime reservationTime,int seatNumber){
        this.CustomerID = CustoemrID;
        this.customerName = CustomerName;
        this.BusNumber = BusNumber;
        this.reservationTime = reservationTime;
        this.seatNumber = seatNumber;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(String busNumber) {
        BusNumber = busNumber;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public LocalDateTime getResercationTime(){
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getSeatNumber(){
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return String.format(
            "Reservation\n" +
            "Customer ID  : %s\n" +
            "Customer Name  : %s\n" +
            "Bus Number  : %s\n" +
            "Reservation Time: %s\n" +
            "Seat Number    : %d\n",
            CustomerID,customerName,BusNumber, reservationTime, seatNumber
        );
    }
}