import java.util.Date;

public class Reserve {
    private String roomNumber;
    private Date checkInDate;
    private Date checkOutDate;

    public Reserve(String roomNumber, Date checkInDate, Date checkOutDate) {
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate;
    }

}
