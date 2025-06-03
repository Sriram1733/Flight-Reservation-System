import java.util.HashMap;
import java.util.Map;

public class Flight {

    private final String flightName;
    private int availableSeats;
    private int ticketPrice;
    private int bookingCounter;
    private final Map<String, Passenger> bookings;

    public Flight(String flightName) {
        this.flightName = flightName;
        this.availableSeats = 10;
        this.ticketPrice = 5000;
        this.bookings = new HashMap<>();
        this.bookingCounter = 0;
    }

    public String bookTickets(String passengerName, int age, int seats) {
        if(seats <= availableSeats) {
            bookingCounter++;
            String bookingId = "T" + bookingCounter;
            Passenger passenger = new Passenger(bookingId, passengerName, age, seats);
            bookings.put(bookingId,passenger);
            availableSeats -= seats;
            ticketPrice += seats * 200;
            return bookingId;
        }
        else {
            System.out.println("Booking Failed : Not enough seats are available");
            return null;
        }
    }

    public void cancelBooking(String bookingId) {
        Passenger passenger = bookings.get(bookingId);
        if(passenger != null) {
            int seats = passenger.getSeatsBooked();
            availableSeats += seats;
            ticketPrice -= seats * 200;
            bookings.remove(bookingId);
            System.out.println("Booking cancelled successfully. Refund issued for " + seats + " seats.");
        }
        else {
            System.out.println("Cancellation failed: Booking ID not found.");
        }
    }

    public void displayFlightDetails() {
        System.out.println("Flight: " + flightName);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Current Ticket Price: " + ticketPrice);
    }

    public void displayDetails() {
        System.out.println("Flight: " + flightName);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Current Ticket Price: " + ticketPrice);
        System.out.println("Passengers:");
        for(Passenger passenger : bookings.values()) {
            System.out.println(passenger);
        }
    }

    public String getFlightName() {
        return  flightName;
    }
}
