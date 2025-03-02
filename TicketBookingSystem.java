class TicketBookingSystem {
    private int availableSeats = 5;

    public synchronized void bookTicket(String passenger) {
        if (availableSeats > 0) {
            System.out.println(passenger + " successfully booked a seat.");
            availableSeats--;
        } else {
            System.out.println("No seats available for " + passenger);
        }
    }
}

class Passenger extends Thread {
    private TicketBookingSystem bookingSystem;
    private String name;

    public Passenger(TicketBookingSystem bookingSystem, String name, int priority) {
        this.bookingSystem = bookingSystem;
        this.name = name;
        setPriority(priority);
    }

    public void run() {
        bookingSystem.bookTicket(name);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Passenger p1 = new Passenger(system, "VIP_John", Thread.MAX_PRIORITY);
        Passenger p2 = new Passenger(system, "Alice", Thread.NORM_PRIORITY);
        Passenger p3 = new Passenger(system, "Bob", Thread.NORM_PRIORITY);
        Passenger p4 = new Passenger(system, "VIP_Mary", Thread.MAX_PRIORITY);
        Passenger p5 = new Passenger(system, "Charlie", Thread.NORM_PRIORITY);
        Passenger p6 = new Passenger(system, "David", Thread.NORM_PRIORITY);
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
    }
}
