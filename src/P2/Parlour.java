// If a customer arrives when there is an empty seat, the Customer can immediately take a seat
// If a customer arrives when all seats are occupied, then all arriving Customers have to wait for all current Customers to leave

package P2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Parlour {
    private final int SEATS = 5;
    private final Semaphore parlourLock = new Semaphore(SEATS, true);
    private int time;

    public Parlour(int time) {
        this.time = 0;
    }
    // Loop and keep track of time.
    public void run(ArrayList<Customer> customer) {
        while(time loop) {
            if(customer.getArrivalTime() == time) {
                //pop the customer that has same arrival time
                //start those threads
                Thread.sleep(1000);
                time++;
            }

        }

    }

    // Return true if a Customer was successfully seated
    public boolean seatCustomer() {
        return true;
    }

    // Return true if Customer is finished eating their ice cream
    public boolean isDone() {
        return true;
    }

    // Return true if the Parlour has 5 Customers seated
    public boolean isFull() {
        return true;
    }
}
