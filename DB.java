//import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<Customer> customers = new ArrayList<Customer>();
    public static List<Bus> Buses = new ArrayList<Bus>();
    public static List<Customer> Login = new ArrayList<Customer>();
    public static List<Reservation> Reservation = new ArrayList<Reservation>();

    public static List<Reservation> getReservation() {
        return Reservation;
    }

    public static void setReservation(List<Reservation> reservation) {
        Reservation = reservation;
    }
    
    public static void data(){
        DB.customers.add(new Customer("C01","Ahamath","769990389","mohamedahamath01@gmail.com","28B saheeb Road Kalmunai 05","Kalmunai","Ahamath48","A1234","2004/01/16",35));
        DB.customers.add(new Customer("C02","Rikas","755896319","rikas0254@gmail.com","09A School Road Kaththankudy","Kaththankudy","Rikas12","R52869","2003/02/14",22));
        DB.customers.add(new Customer("C03","Shan","789645286","abilashanhan08@gmail.com","10C thas Road Batticaloa 01","Batticaloa","Abilashan89","A8952","2002/01/16",28));
        DB.customers.add(new Customer("C04","Havi","708956248","havitharshan45@gmail.com","11A Arumuhathan kudy irupu Road Eravur 01","Eravur","Havi55","Havi25687","2002/01/16",40));
    
        DB.Buses.add(new Bus("B01","BT 2598",50,"Valachenai","Kalmunai",LocalTime.parse("08:30"),250.0));
        DB.Buses.add(new Bus("B02","TM 2568",50,"Valachenai","Colombo",LocalTime.parse("02:44"),2000.0));
        DB.Buses.add(new Bus("B03","BI 7821",50,"Batticaloa","Nuwaraliya",LocalTime.parse("07:44"),2000.0));
        DB.Buses.add(new Bus("B04","PT 5412",50,"Colombo","Polanaruwa",LocalTime.parse("07:44"),1800.0));
        //DB.Buses.add(new Bus("B05","ST 8965",50,"Kurunagal","Kandy",LocalTime.parse("07:44"),2500.0));
        DB.Buses.add(new Bus("B05","ST 8965",1,"Kurunagal","Kandy",LocalTime.parse("07:44"),2500.0));
        
        DB.Reservation.add(new Reservation("C01","Ahamath","ST 8965", LocalDateTime.of(2023, 7, 17, 8, 30), 20));



        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
        DB.Reservation.add(new Reservation("C01","Ahamath","BT 2598", LocalDateTime.of(2023, 7, 17, 8, 30), 20));
         
       /*  DB.Reservation.add(new Reservation("C02","Ahamath", LocalDateTime.of(2023, 7, 17, 10, 0), 15));
        DB.Reservation.add(new Reservation("C03","Rikas", LocalDateTime.of(2023, 7, 17, 13, 45), 10));
        DB.Reservation.add(new Reservation("C04","Abilas", LocalDateTime.of(2023, 7, 18, 9, 30), 5));
        DB.Reservation.add(new Reservation("C05","Ammar", LocalDateTime.of(2023, 7, 18, 11, 0), 8));
   */
    }
} 