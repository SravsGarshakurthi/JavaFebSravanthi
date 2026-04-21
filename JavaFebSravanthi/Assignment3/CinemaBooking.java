package Assignment3;

// 1. TicketCounter class with synchronized booking
class TicketCounter {

    private int availableSeats = 10;

    // 2. synchronized — only ONE thread can execute this at a time
    public synchronized boolean bookSeat(String counterName) {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println(counterName + " booked a seat. Remaining: " + availableSeats);
            return true;
        } else {
            System.out.println(counterName + ": No seats available!");
            return false;
        }
    }

    // Getter for final report
    public int getAvailableSeats() {
        return availableSeats;
    }
}

public class CinemaBooking {

    public static void main(String[] args) {

        // 3. Single shared TicketCounter — all threads use the SAME object
        TicketCounter counter = new TicketCounter();

        // Create three threads using lambda expressions
        Thread counterA = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                counter.bookSeat("Counter-A");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Counter-A");

        Thread counterB = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                counter.bookSeat("Counter-B");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Counter-B");

        Thread counterC = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                counter.bookSeat("Counter-C");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Counter-C");

        // 4. Start all threads simultaneously
        counterA.start();
        counterB.start();
        counterC.start();

        // Wait for all threads to finish
        try {
            counterA.join();
            counterB.join();
            counterC.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 5. Final report after all threads complete
        System.out.println("\nBooking closed. Seats remaining: " + counter.getAvailableSeats());
    }
}
