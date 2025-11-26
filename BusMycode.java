import java.sql.Time;

public class BusMycode {

    private String Number,statingpoint, endingpoint;
    private int seat,fare;
    private Time starting,endTime;
    
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getEndingpoint() {
        return endingpoint;
    }

    public void setEndingpoint(String endingpoint) {
        this.endingpoint = endingpoint;
    }

    public int getFare() {
        return fare;
    }
    
    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Time getStarting() {
        return starting;
    }

    public void setStarting(Time starting) {
        this.starting = starting;
    }

    public String getStatingpoint() {
        return statingpoint;
    }

    public void setStatingpoint(String statingpoint) {
        this.statingpoint = statingpoint;
    }
}