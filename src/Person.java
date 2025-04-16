import java.util.ArrayList;
import java.util.Date;

public class Person {
    public String name;
    private ArrayList<Reserve> reserves;

    public Person(String name) {
        this.name = name;
        this.reserves = new ArrayList<>();
    }

    protected ArrayList<Reserve> getReserves() {
        return reserves;
    }

    public String addABooking(String room, Date checkIn, Date checkOut) {
        Reserve reserve = new Reserve(room, checkIn, checkOut);
        this.reserves.add(reserve);
        return "Booking adicionado";
    }
}
