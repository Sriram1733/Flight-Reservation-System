import java.util.*;

public class Main {
    static List<Flight> flights = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;

        flights.add(new Flight("Indigo"));
        flights.add(new Flight("SpiceJet"));

        while(isValid) {
            System.out.println("\n--- Flight Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Flight Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            String flightName;

            switch (choice) {
                case 1 :
                    System.out.print("Enter flight name (Indigo/SpiceJet): ");
                    sc.nextLine();
                    flightName = sc.nextLine();
                    boolean flag = false;
                    for(Flight flight : flights) {
                        if(flight.getFlightName().equals(flightName)) {
                            flag = true;
                            flight.displayFlightDetails();
                            System.out.print("Enter passenger name: ");
                            String passengerName = sc.nextLine();
                            System.out.print("Enter passenger age: ");
                            int age = sc.nextInt();
                            System.out.print("Enter number of seats to book: ");
                            int seats = sc.nextInt();

                            String bookingId = flight.bookTickets(passengerName, age, seats);
                            if(bookingId != null) {
                                System.out.println("Booking successfully. Your booking ID is: " + bookingId);
                            }
                        }
                    }
                    if(!flag) System.out.println("Invalid flight name. Please try again.");
                    break;
                case 2:
                    System.out.print("Enter flight name (Indigo/SpiceJet): ");
                    sc.nextLine();
                    flightName = sc.nextLine();
                    System.out.print("Enter booking ID: ");
                    String bookingId = sc.nextLine();
                    for(Flight flight : flights) {
                        if(flight.getFlightName().equals(flightName)) {
                            flight.cancelBooking(bookingId);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter flight name (Indigo/SpicyJet): ");
                    sc.nextLine();
                    flightName = sc.nextLine();
                    for(Flight flight : flights) {
                        if(flight.getFlightName().equals(flightName)) {
                            flight.displayDetails();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting System. Thank You!!");
                    isValid = false;
                default:
                    System.out.println("Invalid choice please try again");
                    break;
            }
        }
    }
}