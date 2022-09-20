/*
 *
 *  File: Farmers.java
 *  Assignment: Assignment 2
 *  Course: COMP2240, Operating Systems
 *  Author: Olivia Favos
 *  Student Number: c3188124
 *
 */

package P1;

public class Farmer implements Runnable {
    private String id;
    private int steps; // A count of how many steps the farmer has taken
    private String home;
    private String destination;
    private Bridge bridge;

    public Farmer(String id, String home, Bridge bridge) {
        this.id = id;
        this.home = home;
        this.bridge = bridge;
    }
    @Override public void run() {
        this.bridge.use(this);
    }

    public String getDestination() {
        return this.destination;
    }
    public void setDestination() {
        if(this.home.equals("North")) {
            this.destination = "South";
        }

        else if(this.home.equals("South")) {
            this.destination = "North";
        }
    }

    public void incrementStep() {
        this.steps++;
    }

    public String getId() {
        return this.id;
    }
}
