package P2;

public class Customer implements Runnable {
    private String id; // implement as C + id
    private int arrivalTime;
    private int iceCreamEatingTime;
    private int leavingTime;
    private boolean isSeated;
    private Parlour parlour;

    public Customer(String id, int arrivalTime, int iceCreamEatingTime, Parlour parlour) {
        this.id = "";
        this.arrivalTime = 0;
        this.iceCreamEatingTime = 0;
        this.parlour = parlour;
    }

    @Override public void run() {
        parlourLock.acquire();
        parlour.
    }

    public String getId() {
        return this.id;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getIceCreamEatingTime() {
        return this.iceCreamEatingTime;
    }

    public int getLeavingTime() {
        return this.leavingTime;
    }

    public boolean isSeated() {
        return this.isSeated;
    }

    // Performs a check to see if all customers in the parlour have finished eating their ice cream
    public boolean checkAllFinished() {
        boolean finished = true;

        for (int i : customers) {
            if (customers.get(i).isFinished == false) {
                finished = false;
            }

            else {
                finished = true;
            }
        }

        return finished;
    }
}
