public class Booking {
    private Person person;
    private Reserve[] reserves;

    public Booking(Person person, Reserve[] reserves) {
        this.person = person;
        this.reserves = reserves;
    }
}
