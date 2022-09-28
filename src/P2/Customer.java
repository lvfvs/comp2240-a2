package P2;

public class Customer implements Runnable {
    private String id; // implement as C + id
    private int arrivalTime;
    private int iceCreamEatingTime;
    private int leavingTime;
    private boolean isSeated;
    private int timeSeated;
    private Parlour parlour;

    public Customer(String id, int arrivalTime, int iceCreamEatingTime, Parlour parlour) {
        this.id = "";
        this.arrivalTime = 0;
        this.iceCreamEatingTime = 0;
        this.parlour = parlour;
    }

    @Override public void run() {
        isSeated = false;
        while(!isSeated()) {
            if(!parlour.isFull()) {
                parlour.acquireSemaphore();
                isSeated = parlour.seatCustomer();
                parlour.releaseSemaphore();
            }

            setTimeSeated(parlour.getTime());

            while(parlour.getTime() != iceCreamEatingTime + timeSeated) {
                Thread.sleep(10);
            }

            parlour.acquireSemaphore();
            parlour.leaveParlour();
            parlour.releaseSemaphore();
        }
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

    public int getTimeSeated() {
        return this.timeSeated;
    }

    public void setTimeSeated(int newTimeSeated) {
        this.timeSeated = newTimeSeated;
    }

    /*// Performs a check to see if all customers in the parlour have finished eating their ice cream
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
    }*/
}
