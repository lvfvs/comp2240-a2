// If a customer arrives when there is an empty seat, the Customer can immediately take a seat
// If a customer arrives when all seats are occupied, then all arriving Customers have to wait for all current Customers to leave

package P2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Parlour {
    private final int SEATS = 5;
    private final Semaphore seat = new Semaphore(SEATS, true);
    private ArrayList<Customer> customers;
    private int numberofCustomers = customers.size();
    private int numberOfSeats = 5;
    private boolean isFull;
    private int finishedCustomers = 0;
    private int time;

    public Parlour() {
        this.time = 0;
    }

    public void run(ArrayList<Customer> customers) {
        while(numberofCustomers != finishedCustomers) {
            try {
                while(customers.get(0).getArrivalTime() == time) {
                    customers.remove(0);
                    finishedCustomers++;
                }

                Thread.sleep(1000);
                time++;
            }

            catch(InterruptedException e){
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void acquireSemaphore() {
        try {
            seat.acquire();
        }

        catch(InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void releaseSemaphore() {
        seat.release();
    }

    public int getTime() {
        return this.time;
    }


    // Return true if a Customer was successfully seated
    public boolean seatCustomer() {
        if(!isFull) {
            return true;
        }

        else{
            return false;
            }
    }

    // Return true if Customer is finished eating their ice cream
    public int leaveParlour() {
        return numberOfSeats++;
    }

    // Return true if the Parlour has 5 Customers seated
    public boolean isFull() {
        boolean full = false;

        if(customers.size() >= 5) {
            full = true;
        }

        return full;
    }
}