public class Passenger {
    private String bookingId;
    private String name;
    private int age;
    private int seatsBooked;

    public Passenger(String bookingId, String name, int age, int seatsBooked) {
        this.bookingId = bookingId;
        this.name = name;
        this.age = age;
        this.seatsBooked = seatsBooked;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    @Override
    public String toString() {
        return "Passenger: BookingId = " + bookingId + ", name = " + name + ", age = " + age + ", seatBooked = " + seatsBooked;

    }
}
